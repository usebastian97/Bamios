package com.su.bmi.widgets

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.su.bmi.ui.theme.BMITheme

@Composable
fun RoundedCard(
    modifier: Modifier = Modifier,
    color: androidx.compose.ui.graphics.Color = MaterialTheme.colors.background,
    elevation: Dp = 4.dp,
    content: @Composable() () -> Unit
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(15.dp),
        backgroundColor = color,
        elevation = elevation
    ) {
        content()
    }
}

@Preview
@Composable
private fun RoundedCardPreview() {
    BMITheme {
        RoundedCard {
            Text(text = "RoundedCard", modifier = Modifier.padding(8.dp))
        }
    }
}