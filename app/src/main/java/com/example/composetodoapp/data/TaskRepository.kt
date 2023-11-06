package com.example.composetodoapp.data

import kotlinx.coroutines.flow.Flow

interface TaskRepository {

    suspend fun getTasks(): Flow<List<TaskEntity>>
    suspend fun insertTask(task: TaskEntity)
    suspend fun updateTask(task: TaskEntity)
    suspend fun deleteTask(task: TaskEntity)

}