package com.example.composetodoapp.data

import androidx.compose.runtime.MutableState
import kotlinx.coroutines.flow.Flow

class TaskRepositoryImpl(
    private val dao: TaskDao,
) : TaskRepository {
    override suspend fun insertTask(task: Task) {
        dao.insertTask(task)
    }

    override suspend fun deleteTask(task: Task) {
        dao.deleteTask(task)
    }

    override suspend fun getTaskById(id: Int): Task? {
        return dao.getTaskById(id = id)
    }

    override fun getTasks(): List<Task> {
        return dao.getTasks()
    }
}