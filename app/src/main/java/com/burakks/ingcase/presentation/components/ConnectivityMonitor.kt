package com.burakks.ingcase.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import com.burakks.ingcase.R
import com.burakks.ingcase.ui.theme.SpaceLarge
import com.burakks.ingcase.ui.theme.TextDark

@Composable
fun ConnectivityMonitor(
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            stringResource(R.string.no_internet_connection),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(SpaceLarge),
            style = MaterialTheme.typography.body1.copy(
                fontSize = 20.sp
            ),
            color = TextDark
        )
    }
}