package com.burakks.ingcase.presentation.components

import android.widget.Space
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.burakks.ingcase.R
import com.burakks.ingcase.ui.theme.*

@ExperimentalComposeUiApi
@Composable
fun MainSearchBar(
    query: String,
    onQueryChanged: (String) -> Unit,
    onExecuteSearch: () -> Unit,
) {
    val keyboardController = LocalSoftwareKeyboardController.current

    Surface(
        modifier = Modifier
            .fillMaxWidth(),
        color = MaterialTheme.colors.surface,
    ) {
        Row(
            verticalAlignment = CenterVertically,
            modifier = Modifier
                .padding(SpaceLarge)
        ) {
            TextField(
                modifier = Modifier.weight(8f),
                value = query,
                onValueChange = {
                    onQueryChanged(it)
                },
                textStyle = Typography.body1.copy(
                    color = TextDark,
                    fontWeight = FontWeight.Bold
                ),
                placeholder = {
                    Text(
                        text = stringResource(
                            id = R.string.username
                        ),
                        color = HintGray
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
                    backgroundColor = colorResource(id = R.color.white),
                )
            )
            Button(
                modifier = Modifier
                    .padding(start = SpaceMedium),
                onClick = {
                    onExecuteSearch()
                    keyboardController?.hide()
                }) {
                Text(
                    text = stringResource(id = R.string.search),
                    color = TextWhite,
                )
            }
        }
    }
}
