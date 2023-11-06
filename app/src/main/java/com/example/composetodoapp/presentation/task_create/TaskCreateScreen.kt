package com.example.composetodoapp.presentation.task_create

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.composetodoapp.data.TaskEntity
import com.example.composetodoapp.data.TaskPriority
import com.example.composetodoapp.presentation.TaskViewModel

@Composable
fun TaskCreateScreen(
    navController: NavController,
    viewModel: TaskViewModel = hiltViewModel()
) {

    var taskTitle by remember { mutableStateOf("") }
    var taskDescription by remember { mutableStateOf("") }


    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            OutlinedTextField(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                value = taskTitle,
                onValueChange = { taskTitle = it },
                label = { Text(text = "Task Title") }
            )

            TextField(
                modifier = Modifier
                    .height(200.dp)
                    .padding(16.dp)
                    .fillMaxWidth(),
                value = taskDescription,
                onValueChange = { taskDescription = it },
                label = { Text(text = "Description") }
            )
            TextButton(
                onClick = {
                    viewModel.insertTask(TaskEntity(
                        title = taskTitle,
                        description = taskDescription,
                        priority = TaskPriority.HIGH,
                        isDone = false
                    ))
                    navController.navigate("TaskListScreen")
                },

            ) {
                Text(text = "Create Task")
            }
        }
    }
}

//@Preview
//@Composable
//fun TaskCreateScreenPreview() {
//    ComposeTodoAppTheme {
//        Surface(
//            modifier = Modifier.fillMaxSize(),
//            color = MaterialTheme.colors.background
//        ) {
//            TaskCreateScreen()
//        }
//    }
//
//}