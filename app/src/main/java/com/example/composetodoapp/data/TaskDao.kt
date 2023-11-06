package com.example.composetodoapp.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTask(taskEntity: TaskEntity)

    @Query("SELECT * FROM `tasks`")
    fun getTasks(): Flow<List<TaskEntity>>

    @Update
    fun updateTasks(task: TaskEntity)

    @Delete
    fun deleteTask(task: TaskEntity)
}