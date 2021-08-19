package com.burakks.ingcase.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import coil.transform.GrayscaleTransformation
import com.burakks.ingcase.domain.model.Repo
import com.burakks.ingcase.ui.theme.SpaceMedium
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@Composable
fun RepoCard(
    repo: Repo,
    modifier: Modifier = Modifier,
    onRepoClick: () -> Unit,
) {
    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier.height(IMAGE_HEIGHT.dp)
    ) {
        Column() {
            Card(
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .padding(
                        all = SpaceMedium,
                    )
                    .clickable(onClick = onRepoClick),
                elevation = 8.dp,
            ) {
                Text(
                    text = repo.name ?: "EMPTY STRING",
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .padding(12.dp)
                        .wrapContentWidth(CenterHorizontally),
                    style = MaterialTheme.typography.caption
                )
            }
        }
    }
}