package com.burakks.ingcase.presentation.navigation

import androidx.navigation.NavType
import androidx.navigation.compose.NamedNavArgument
import androidx.navigation.compose.navArgument

sealed class Screen(
    val route: String,
    val arguments: List<NamedNavArgument>
) {
    object RepoListScreen : Screen(
        route = "repo_list_screen",
        arguments = emptyList()
    )

    object RepoDetailScreen : Screen(
        route = "repo_detail_screen",
        arguments = listOf(navArgument("repoId") {
            type = NavType.IntType
        })
    )
}
