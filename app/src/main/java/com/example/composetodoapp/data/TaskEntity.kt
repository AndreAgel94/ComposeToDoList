package com.example.composetodoapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
data class TaskEntity(
    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "description")
    val description: String,

    @ColumnInfo(name = "isDone")
    val isDone: Boolean,

    val priority : TaskPriority = TaskPriority.MEDIUM,

    @PrimaryKey(autoGenerate = true)
    val id: Int? = null
)
