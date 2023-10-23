package com.example.composetodoapp.presentation.task_list

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.composetodoapp.data.Task
import com.example.composetodoapp.data.TaskPriority
import com.example.composetodoapp.presentation.components.TaskComponent


@Composable
fun TaskListScreen(
    navController: NavController,
    viewModel: TaskListViewModel = hiltViewModel()
) {
    val taskList = viewModel.tasks.value
    val taskListTest = listOf(
        Task(
            "title",
            "description",
            false,
            TaskPriority.HIGH
        ),
        Task(
            "title",
            "description",
            false,
            TaskPriority.HIGH
        ),
        Task(
            "title",
            "description",
            false,
            TaskPriority.HIGH
        ),
        Task(
            "title",
            "description",
            false,
            TaskPriority.HIGH
        ),
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Text(
                modifier = Modifier.padding(8.dp),
                fontSize = 32.sp,
                text = "Your tasks 0/3",
                fontWeight = FontWeight.Bold
            )

            Text(
                modifier = Modifier.padding(8.dp),
                text = "sort by:",
                fontSize = 16.sp,
            )

            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                items(taskListTest) {
                    TaskComponent(
                        taskTitle = it.title,
                        taskDescription = it.description,
                        taskPriority = it.priority
                    )
                }
            }
        }
        FloatingActionButton(
            onClick = {
                navController.navigate("TaskCreateScreen")
            },
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.BottomEnd)
        ) {
            Icon(
                painter = painterResource(
                    id = com.example.composetodoapp.R.drawable.baseline_add_24
                ),
                contentDescription = "add icon"
            )
        }
    }
}

@Preview
@Composable
fun TaskListScreenPreview() {
    val navController = rememberNavController()
    TaskListScreen(navController = navController, hiltViewModel())
}