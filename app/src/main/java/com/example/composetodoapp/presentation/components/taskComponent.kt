package com.example.composetodoapp.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composetodoapp.data.TaskPriority

@Composable
fun taskComponent(
    taskTitle: String,
    taskDescription: String,
    taskPriority: TaskPriority,
    modifier: Modifier = Modifier
) {
    val priorityColor : Color = when(taskPriority.ordinal) {
        (TaskPriority.HIGH.ordinal) -> Color.Red
        (TaskPriority.MEDIUM.ordinal) -> Color.Yellow
        (TaskPriority.LOW.ordinal) -> Color.Green
        else -> Color.Green
    }

    Box(
        modifier = Modifier
            .size(width = 350.dp, height = 150.dp)
            .padding(16.dp)
            .shadow(
                elevation = 1.dp,
                shape = RoundedCornerShape(10.dp)
            )
    )

    {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceBetween

        ) {
            Column(
                modifier = Modifier.fillMaxHeight(1f).padding(5.dp),
                verticalArrangement = Arrangement.SpaceBetween

            ) {
                Text(
                    text = taskTitle,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(text = taskDescription)
                Row() {
                    Text(text = "priority: ")
                    Text(
                        taskPriority.name,
                        color = priorityColor
                    )
                }

            }
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxHeight(1f).padding(5.dp)
            ) {
                Checkbox(checked = true, onCheckedChange = {

                })
            }
        }
    }
}

@Preview
@Composable
fun taskComponentPreview() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        taskComponent(
            taskTitle = "title",
            taskDescription = "description",
            taskPriority = TaskPriority.HIGH
        )
    }

}