package com.burakks.ingcase.presentation.components


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.burakks.ingcase.R
import com.burakks.ingcase.ui.theme.*

@Composable
fun OwnerStatus(
    icon: ImageVector,
    text: String,
    number: String,
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(RadiusMedium),
        modifier = modifier
            .wrapContentWidth()
            .background(Color.White)
            .padding(SpaceMedium),
        elevation = ElevationSmall
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .background(Color.White)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = modifier
                    .weight(5f)
                    .background(Color(0xFFF3F4F6))
            ) {
                Icon(
                    icon,
                    contentDescription = stringResource(id = R.string.status),
                    tint = MediumGray
                )
                Text(
                    text = text,
                    textAlign = TextAlign.Center,
                    color = DarkGray,
                    modifier = modifier
                        .background(Color(0xFFF3F4F6))
                        .padding(SpaceSmall),
                    style = MaterialTheme.typography.body1.copy(
                        fontSize = 24.sp
                    ),
                )
            }
            Text(
                text = number,
                textAlign = TextAlign.Center,
                color = DarkGray,
                style = MaterialTheme.typography.body1.copy(
                    fontSize = 24.sp
                ),
                modifier = modifier
                    .padding(SpaceSmall)
                    .weight(5f),
            )
        }
    }

}