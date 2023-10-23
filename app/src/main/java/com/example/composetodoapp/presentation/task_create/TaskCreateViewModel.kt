package com.example.composetodoapp.presentation.task_create

import androidx.lifecycle.ViewModel
import com.example.composetodoapp.data.Task
import com.example.composetodoapp.data.TaskRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskCreateViewModel @Inject constructor(
    private val repository: TaskRepository
) : ViewModel() {

    fun createTask(task : Task) {
        CoroutineScope(Dispatchers.IO).launch {
            repository.insertTask(task)
        }
    }
}