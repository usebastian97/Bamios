package com.su.bmi.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)

val Red200 = Color(0xfff297a2)
val Red300 = Color(0xffea6d7e)
val Red700 = Color(0xffdd0d3c)
val Red800 = Color(0xffd00036)
val Red900 = Color(0xffc20029)

val backgroundColor = Color(0xFFF0EEF3)
val darkTextColor = Color(0xFF5B6275)
val lightTextColor = Color.Gray
val foregroundColor = Color(0xFFF0EEF3)
val accentColor = Color(0xFF59CAE2)

val color1 = Color(0xFFD5D6D7)
val color2 = Color(0xFFB9C3C9)
val color3 = Color(0xFF2CA1BC)
val color4 = Color(0xFF727789)
val color5 = Color(0xFF4D5468)

val whitishColor = color1
val whitishVariantColor = color2
val bluishColor = color3
val darkVariantColor = color5
val darkColor = color4

@Preview
@Composable
internal fun Color() {
    val colors = listOf(
        backgroundColor, darkTextColor, lightTextColor, foregroundColor, accentColor,
        whitishColor, whitishVariantColor, bluishColor, darkVariantColor, darkColor
    )
    Column {
        colors.forEach {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(16.dp)
                    .background(it)
            )
        }
    }
}
