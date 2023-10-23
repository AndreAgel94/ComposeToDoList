package com.example.composetodoapp.data

import androidx.compose.runtime.MutableState

interface TaskRepository {

    suspend fun insertTask(task: Task)


    suspend fun deleteTask(task: Task)


    suspend fun getTaskById(id: Int): Task?


    fun getTasks(): List<Task>
}