package com.burakks.ingcase.presentation.repo_list

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.burakks.ingcase.R
import com.burakks.ingcase.presentation.components.MainSearchBar
import com.burakks.ingcase.presentation.components.MainTopAppBar
import com.burakks.ingcase.presentation.components.RepoList
import com.burakks.ingcase.presentation.navigation.Screen
import com.burakks.ingcase.ui.theme.SpaceMedium
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalComposeUiApi
@ExperimentalCoroutinesApi
@ExperimentalFoundationApi
@Composable
fun RepoListScreen(
    navController: NavHostController,
    viewModel: RepoListViewModel = hiltViewModel()
) {
    val repoList = viewModel.repos.value
    val query = viewModel.query.value

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        MainTopAppBar(
            navController = navController,
            modifier = Modifier.fillMaxWidth(),
            title = {
                Text(
                    text = stringResource(id = R.string.home),
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colors.onBackground
                )
            },
            showBackArrow = false
        )

        MainSearchBar(
            query = query,
            onQueryChanged = { viewModel.onQueryChanged(it) },
            onExecuteSearch = { viewModel.fetchRepos(query) }
        )

        Spacer(modifier = Modifier.height(SpaceMedium))
        
        RepoList(
            repos = repoList,
            onRepoClick = {
                navController.navigate(
                    Screen.RepoDetailScreen.route
                )
            }
        )

    }
}