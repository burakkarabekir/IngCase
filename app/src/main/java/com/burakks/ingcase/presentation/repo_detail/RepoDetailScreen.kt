package com.burakks.ingcase.presentation.repo_detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavHostController
import com.burakks.ingcase.domain.model.Repo
import com.burakks.ingcase.presentation.components.MainTopAppBar

@Composable
fun RepoDetailScreen(
    navController: NavHostController,
    repo: Repo
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        MainTopAppBar(
            navController = navController,
            modifier = Modifier.fillMaxWidth(),
            title = {
                Text(
                    text = repo.name ?: "Repo Detail Page",
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colors.onBackground
                )
            },
            showBackArrow = true
        )

        Box(modifier = Modifier.fillMaxWidth()) {
            Text("Repo Name: ${repo.name}")
        }
    }
}