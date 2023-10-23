package com.example.composetodoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composetodoapp.presentation.task_create.TaskCreateScreen
import com.example.composetodoapp.presentation.task_list.TaskListScreen
import com.example.composetodoapp.ui.theme.ComposeTodoAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTodoAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "TaskListScreen"
                    ) {
                        composable(route = "TaskListScreen") {
                           TaskListScreen(navController = navController)
                        }
                        composable(route = "TaskCreateScreen") {
                            TaskCreateScreen(navController = navController)
                        }
                    }
                }
            }
        }
    }
}
