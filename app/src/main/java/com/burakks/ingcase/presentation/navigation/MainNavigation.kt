package com.burakks.ingcase.presentation.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.burakks.ingcase.domain.model.Repo
import com.burakks.ingcase.presentation.repo_detail.RepoDetailScreen
import com.burakks.ingcase.presentation.repo_list.RepoListScreen
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalComposeUiApi
@ExperimentalCoroutinesApi
@ExperimentalFoundationApi
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