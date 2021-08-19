package com.burakks.ingcase.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.burakks.ingcase.R
import com.burakks.ingcase.ui.theme.ElevationSmall
import com.burakks.ingcase.ui.theme.SpaceSmall

@ExperimentalComposeUiApi
@Composable
fun MainSearchBar(
    query: String,
    onQueryChanged: (String) -> Unit,
    onExecuteSearch: () -> Unit,
) {
    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current

    Surface(
        modifier = Modifier
            .fillMaxWidth(),
        color = MaterialTheme.colors.surface,
        elevation = ElevationSmall,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextField(
                value = query,
                onValueChange = {
                    onQueryChanged(it)
                },
                modifier = Modifier
                    .padding(SpaceSmall)
                    .align(CenterVertically),
                textStyle = MaterialTheme.typography.body1,
                placeholder = {
                    Text(
                        text = stringResource(
                            id = R.string.username
                        )
                    )
                },
                shape = RoundedCornerShape(SpaceSmall),
                singleLine = true,
                keyboardActions = KeyboardActions(
                    onDone = {
                        onExecuteSearch()
                        keyboardController?.hide()
                    }
                ),
                leadingIcon = {
                    Icon(
                        Icons.Default.Search,
                        contentDescription = "Search Icon"
                    )
                },
                trailingIcon = {
                    Icon(
                        Icons.Default.Clear,
                        contentDescription = "Clear Icon",
                        modifier = Modifier
                            .clickable {
                                onQueryChanged("")
                            }
                    )
                },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = colorResource(id = R.color.white)
                )
            )
            Button(onClick = onExecuteSearch) {
                      Text(text = stringResource(id = R.string.search))
            }
        }
    }
}
