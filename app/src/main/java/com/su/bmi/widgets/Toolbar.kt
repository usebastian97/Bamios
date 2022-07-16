package com.su.bmi.widgets

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.su.bmi.R
import com.su.bmi.ui.theme.BMITheme
import com.su.bmi.ui.theme.darkTextColor
import com.su.bmi.ui.theme.foregroundColor

@Composable
fun Toolbar(
    title: String,
    navigationIcon: @Composable() (() -> Unit)? = null,
    actions: @Composable() RowScope.() -> Unit = {},
    toolbarBackground: androidx.compose.ui.graphics.Color = foregroundColor
) {
    TopAppBar(
        title = {
            Text(
                text = title,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                color = darkTextColor
            )
        },
        navigationIcon = navigationIcon,
        actions = actions,
        elevation = 0.dp,
        backgroundColor = toolbarBackground
    )
}

@Preview
@Composable
fun ToolbarPreview() {
    BMITheme {
        Toolbar(title = stringResource(R.string.app_name),
            navigationIcon = { RoundIconButton(vectorImage = Icons.Outlined.Notifications, onClick = { })
            },
            actions = {
                RoundIconButton(vectorImage  = Icons.Outlined.Person, onClick = { })
            }
        )
    }
}

