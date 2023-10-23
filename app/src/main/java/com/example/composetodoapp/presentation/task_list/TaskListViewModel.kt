package com.example.composetodoapp.presentation.task_list

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.composetodoapp.data.Task
import com.example.composetodoapp.data.TaskRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskListViewModel @Inject constructor(
    private val repository: TaskRepository
) : ViewModel() {

    val tasks: MutableState<List<Task>> = mutableStateOf(emptyList())

    init {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val tasksResult = repository.getTasks()
                tasks.value = tasksResult
            } catch (e: Exception) {
                Log.d("TaskListViewModel", "getTasks exception $e")
            }
        }
    }
}