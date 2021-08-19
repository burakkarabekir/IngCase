package com.burakks.ingcase.presentation.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.burakks.ingcase.domain.model.Repo
import kotlinx.coroutines.ExperimentalCoroutinesApi


const val IMAGE_HEIGHT = 150

@ExperimentalFoundationApi
@ExperimentalCoroutinesApi
@Composable
fun RepoList(
    repos: List<Repo>,
    onRepoClick: () -> Unit = {},
) {
    Box(
        modifier = Modifier
            .padding(24.dp)
    ) {
        LazyColumn {
            itemsIndexed(
                items = repos
            ) { _, repo ->
                RepoCard(
                    repo = repo,
                    modifier = Modifier.height(IMAGE_HEIGHT.dp),
                    onRepoClick = onRepoClick

                )
            }
        }
    }
}