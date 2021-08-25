package com.burakks.ingcase.presentation.repo_list

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.ExperimentalMaterialApi
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
import com.burakks.ingcase.presentation.components.*
import com.burakks.ingcase.ui.theme.SpaceLarge
import com.burakks.ingcase.ui.theme.SpaceSmall

@ExperimentalMaterialApi
@ExperimentalComposeUiApi
@Composable
fun RepoListScreen(
    navController: NavHostController,
    viewModel: RepoListViewModel = hiltViewModel(),
) {
    val repos = viewModel.repos.value
    val query = viewModel.query.value

    val isConnected = viewModel.isConnected.value
    // val isQueryValid = viewModel.isQueryValid.value
    val isLoading = viewModel.isLoading.value

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

        Spacer(modifier = Modifier.height(SpaceSmall))

        MainCircularProgressBar(isLoading)

        ConnectivityMonitor(isConnected)

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(SpaceLarge)
        ) {
            itemsIndexed(
                items = repos
            ) { _, repo ->
                RepoCard(
                    repo = repo,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    navController.navigate(
                        "repo_detail_screen/${repo.id}"
                    )
                }
            }
        }
    }
}

