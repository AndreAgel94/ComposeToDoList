package com.example.composetodoapp.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composetodoapp.data.TaskPriority

@Composable
fun taskComponent(
    taskTitle: String,
    taskDescription: String,
    taskPriority: TaskPriority,
) {

    Box(
        modifier = Modifier
            .size(width = 350.dp, height = 100.dp)
            .padding(16.dp)
    )

    {
        Row(modifier = Modifier) {
            Column {
                Text(text = "")
                Text(text = "")
                Text(text = "")
            }
            Column {

            }
        }
    }
}

//@Preview
//@Composable
//fun taskComponentPreview() {
//    Box(modifier = Modifier
//        .fillMaxSize()
//        .background(Color.White)) {
//        taskComponent(
//            taskTitle = "title",
//            taskDescription = "description",
//            taskPriority = TaskPriority.HIGH
//        )
//    }
//
//}