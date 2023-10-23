package com.example.composetodoapp.data

import androidx.compose.runtime.MutableState
import androidx.room.*

@Dao
interface TaskDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(task: Task)

    @Delete
    suspend fun deleteTask(task: Task)

    @Query("SELECT * FROM task WHERE id =:id")
    suspend fun getTaskById(id: Int) : Task?

    @Query("SELECT * FROM Task")
    fun getTasks(): List<Task>
}