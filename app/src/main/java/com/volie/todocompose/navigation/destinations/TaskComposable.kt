package com.volie.todocompose.navigation.destinations

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.volie.todocompose.ui.screens.task.TaskScreen
import com.volie.todocompose.util.Action
import com.volie.todocompose.util.Constants.TASK_ARGUMENT_KEY
import com.volie.todocompose.util.Constants.TASK_SCREEN

@ExperimentalMaterial3Api
fun NavGraphBuilder.taskComposable(
    navigateToListScreen: (Action) -> Unit
) {
    composable(
        route = TASK_SCREEN,
        arguments = listOf(navArgument(TASK_ARGUMENT_KEY) {
            type = NavType.IntType
        })
    ) { navBackStackEntry ->
        navBackStackEntry.arguments!!.getInt(TASK_ARGUMENT_KEY)
        TaskScreen(navigateToListScreen = navigateToListScreen)
    }
}