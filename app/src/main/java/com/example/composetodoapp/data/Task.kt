package com.example.composetodoapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Task(
    val title: String,
    val description: String,
    val isDone: Boolean,
    val priority : TaskPriority = TaskPriority.MEDIUM,
    @PrimaryKey val id: Int? = null
)
