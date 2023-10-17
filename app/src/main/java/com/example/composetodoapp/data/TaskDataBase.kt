package com.example.composetodoapp.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Task::class],
    version = 1
)
abstract class TaskDataBase: RoomDatabase() {

    abstract val dao: TaskDao
}