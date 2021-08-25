package com.burakks.ingcase.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.burakks.ingcase.domain.model.Repo
import com.burakks.ingcase.ui.theme.*
import com.burakks.ingcase.util.Constants

@ExperimentalMaterialApi
@Composable
fun RepoCard(
    repo: Repo,
    modifier: Modifier = Modifier,
    iconSize: Dp = 32.dp,
    onItemClick: () -> Unit = {},
) {
    Card(
        shape = RoundedCornerShape(RadiusSmall),
        modifier = modifier
            .fillMaxWidth()
            .padding(SpaceSmall),
        onClick = onItemClick,
        backgroundColor = TextWhite,
        elevation = ElevationSmall,
    ) {
        Row(
            modifier = modifier
                .padding(
                    horizontal = SpaceMedium,
                    vertical = SpaceSmall
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                modifier = Modifier
                    .weight(8f),
                text = repo.name,
                style = MaterialTheme.typography.body1.copy(
                    fontSize = 18.sp
                ),
                color = DarkGray,
                overflow = TextOverflow.Ellipsis,
                maxLines = Constants.MAX_POST_DESCRIPTION_LINES
            )
        }
    }
}