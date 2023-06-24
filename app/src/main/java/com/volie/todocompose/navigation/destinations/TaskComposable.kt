package com.volie.todocompose.navigation.destinations

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.volie.todocompose.ui.screens.task.TaskScreen
import com.volie.todocompose.ui.viewmodels.SharedViewModel
import com.volie.todocompose.util.Action
import com.volie.todocompose.util.Constants.TASK_ARGUMENT_KEY
import com.volie.todocompose.util.Constants.TASK_SCREEN

@ExperimentalMaterial3Api
fun NavGraphBuilder.taskComposable(
    sharedViewModel: SharedViewModel,
    navigateToListScreen: (Action) -> Unit
) {
    composable(
        route = TASK_SCREEN,
        arguments = listOf(navArgument(TASK_ARGUMENT_KEY) {
            type = NavType.IntType
        })
    ) { navBackStackEntry ->
        val taskId = navBackStackEntry.arguments!!.getInt(TASK_ARGUMENT_KEY)
        sharedViewModel.getSelectedTask(taskId)
        val selectedTask by sharedViewModel.selectedTask.collectAsState()

        LaunchedEffect(key1 = taskId) {
            if (selectedTask != null || taskId == -1) {
                sharedViewModel.updateTaskField(selectedTask = selectedTask)
            }
        }

        TaskScreen(
            sharedViewModel = sharedViewModel,
            selectedTask = selectedTask,
            navigateToListScreen = navigateToListScreen
        )
    }
}