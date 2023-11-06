package com.example.composetodoapp.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composetodoapp.data.TaskEntity
import com.example.composetodoapp.data.TaskRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskViewModel @Inject constructor(
    private val repository: TaskRepository
) : ViewModel() {

    private val _tasks: MutableStateFlow<List<TaskEntity>> = MutableStateFlow(emptyList())
    val tasks = _tasks.asStateFlow()

    init {
        getTasks()
    }

    private fun getTasks() {
        viewModelScope.launch(Dispatchers.IO){
            repository.getTasks().collect {data->
                Log.d("TaskViewModel", "Collected tasks: $data")
                _tasks.emit(data)
            }
        }
    }

    fun updateTask(task: TaskEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateTask(task)
        }
    }

    fun insertTask(task: TaskEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertTask(task)
        }
    }

    fun deleteTask(task: TaskEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteTask(task)
        }
    }
}