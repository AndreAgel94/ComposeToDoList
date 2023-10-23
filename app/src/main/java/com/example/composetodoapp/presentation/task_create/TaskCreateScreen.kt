package com.example.composetodoapp.presentation.task_create

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.composetodoapp.ui.theme.ComposeTodoAppTheme

@Composable
fun TaskCreateScreen(
    navController: NavController
) {

    var taskTitle by remember { mutableStateOf("") }
    var taskDescription by remember { mutableStateOf("") }


    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                value = taskTitle,
                onValueChange = {taskTitle = it},
                label = { Text(text = "Task Title")}
            )

            TextField(
                modifier = Modifier
                    .height(200.dp)
                    .padding(16.dp)
                    .fillMaxWidth(),
                value = taskDescription,
                onValueChange = {taskDescription = it},
                label = { Text(text = "Description") }
            )
        }
    }
}

@Preview
@Composable
fun TaskCreateScreenPreview() {
    ComposeTodoAppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            //TaskCreateScreen()
        }
    }

}