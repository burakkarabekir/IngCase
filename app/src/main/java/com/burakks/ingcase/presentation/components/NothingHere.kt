package com.burakks.ingcase.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import com.burakks.ingcase.R
import com.burakks.ingcase.ui.theme.SpaceMedium

@Composable
fun NothingHere() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        Column {
            Text(
                modifier = Modifier
                    .padding(SpaceMedium)
                    .align(Alignment.CenterHorizontally),
                text = "¯\\_(ツ)_/¯",
                style = MaterialTheme.typography.body1.copy(
                    fontSize = 32.sp
                ),

                )
            Text(
                modifier = Modifier
                    .padding(SpaceMedium)
                    .align(Alignment.CenterHorizontally),
                text = stringResource(R.string.nothing_here),
                style = MaterialTheme.typography.body1,
            )
        }

    }
}