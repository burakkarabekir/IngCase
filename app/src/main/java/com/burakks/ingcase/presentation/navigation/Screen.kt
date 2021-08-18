package com.burakks.ingcase.presentation.navigation

sealed class Screen(val route: String) {
    object ReposScreen: Screen("repos_screen")
    object RepoDetailScreen: Screen("repo_detail_screen")
}
