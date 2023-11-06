package com.example.composetodoapp.data

import kotlinx.coroutines.flow.Flow

class TaskRepositoryImpl(
    private val dao: TaskDao,
) : TaskRepository {
    override suspend fun getTasks(): Flow<List<TaskEntity>> = dao.getTasks()

    override suspend fun insertTask(task: TaskEntity) = dao.insertTask(task)

    override suspend fun updateTask(task: TaskEntity) = dao.updateTasks(task)

    override suspend fun deleteTask(task: TaskEntity) = dao.deleteTask(task)

}