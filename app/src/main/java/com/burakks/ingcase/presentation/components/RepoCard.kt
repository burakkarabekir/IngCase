package com.burakks.ingcase.presentation.components

import android.os.Bundle
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.burakks.ingcase.R
import com.burakks.ingcase.domain.model.Repo
import com.burakks.ingcase.ui.theme.ElevationSmall
import com.burakks.ingcase.ui.theme.RadiusSmall
import com.burakks.ingcase.ui.theme.SpaceMedium
import com.burakks.ingcase.ui.theme.SpaceSmall
import com.burakks.ingcase.util.Constants
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@Composable
fun RepoCard(
    repo: Repo,
    modifier: Modifier = Modifier,
    iconSize: Dp = 64.dp,
    isLiked: Boolean,
    onLikeClick: (Boolean) -> Unit = {},
    onRepoClick: () -> Unit = {},
) {
    Card(
        shape = RoundedCornerShape(RadiusSmall),
        modifier = modifier
            .fillMaxWidth()
            .padding(SpaceSmall)
            .clickable(onClick = onRepoClick),
        elevation = ElevationSmall,
    ) {
        Row(
            modifier = modifier
                .padding(
                    horizontal = SpaceMedium,
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                modifier = Modifier
                    .weight(8f),
                text = repo.name ?: stringResource(R.string.repo_name),
                style = MaterialTheme.typography.body1.copy(
                    fontSize = 24.sp
                ),
                overflow = TextOverflow.Ellipsis,
                maxLines = Constants.MAX_POST_DESCRIPTION_LINES
            )
            IconButton(
                modifier = Modifier
                    .weight(2f)
                    .size(iconSize),
                onClick = {
                    onLikeClick(!isLiked)
                }

            ) {
                Icon(
                    imageVector = Icons.Filled.Favorite,
                    tint = if (isLiked) {
                        Color.Red
                    } else {
                        Color.White
                    },
                    contentDescription = if (isLiked) {
                        stringResource(id = R.string.unlike)
                    } else {
                        stringResource(id = R.string.like)
                    }
                )
            }

        }
    }
}