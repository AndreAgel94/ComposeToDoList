package com.example.composetodoapp.presentation.task_list

import androidx.lifecycle.ViewModel
import com.example.composetodoapp.data.TaskRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TaskListViewModel @Inject constructor(
    private val repository: TaskRepository
) : ViewModel() {

}