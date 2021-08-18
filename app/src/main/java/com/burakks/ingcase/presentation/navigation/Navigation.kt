package com.burakks.ingcase.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.burakks.ingcase.presentation.repo_detail.RepoDetailScreen
import com.burakks.ingcase.presentation.repos.ReposScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.ReposScreen.route
    ) {
        composable(
            Screen.ReposScreen.route
        ) {
            ReposScreen(
                navController = navController,
            )
        }
        composable(
            Screen.RepoDetailScreen.route,
        ) {
            RepoDetailScreen(
                navController = navController
            )
        }
    }


}