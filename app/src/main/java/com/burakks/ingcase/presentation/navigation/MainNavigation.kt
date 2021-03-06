package com.burakks.ingcase.presentation.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.burakks.ingcase.presentation.repo_detail.RepoDetailScreen
import com.burakks.ingcase.presentation.repo_list.RepoListScreen

@ExperimentalMaterialApi
@ExperimentalComposeUiApi
@Composable
fun MainNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.RepoListScreen.route,
        modifier = Modifier.fillMaxSize()
    ) {
        composable(
            Screen.RepoListScreen.route
        ) {
            RepoListScreen(
                navController = navController,
            )
        }
        composable(
            Screen.RepoDetailScreen.route + "/{repoId}",
            arguments = Screen.RepoDetailScreen.arguments
        ) { entry ->
            RepoDetailScreen(
                navController = navController,
                entry.arguments?.getInt("repoId")
            )
        }
    }


}