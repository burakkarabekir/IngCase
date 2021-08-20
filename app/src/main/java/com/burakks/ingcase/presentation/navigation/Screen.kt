package com.burakks.ingcase.presentation.navigation

sealed class Screen(val route: String) {
    object RepoListScreen : Screen(route = "repo_list_screen")
    object RepoDetailScreen : Screen(route = "repo_detail_screen")
}
