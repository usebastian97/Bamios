package com.su.bmi.widgets

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.su.bmi.ui.theme.*
import java.util.*


private val IconButtonSizeModifier = Modifier.height(50.dp)

@Composable
fun RoundedButton(
    text: String,
    modifier: Modifier = Modifier,
    elevation: Dp = 4.dp,
    onClick: () -> Unit,
    backGroundColor: Color = Red800,
    contentColor: Color = foregroundColor
) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(4.dp),
        modifier = modifier then IconButtonSizeModifier,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = backGroundColor,
            contentColor = contentColor
        ),
        elevation = ButtonDefaults.elevation(elevation)
    ) {
        Text(text = text, fontSize = 18.sp)
    }
}

@Composable
fun RoundedToggleButton(
    state: MutableState<Boolean>,
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    activeColor: Color = Red800,
    inactiveColor: Color = backgroundColor
) {

    Button(
        onClick = onClick,
        shape = RoundedCornerShape(16.dp),
        modifier = modifier then IconButtonSizeModifier,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = if (state.value) activeColor else inactiveColor,
            contentColor = if (state.value) foregroundColor else Color.Gray
        )
    ) {
        Text(text = text, fontSize = 18.sp)
    }
}

@Preview
@Composable
private fun ButtonPreview() {
    BMITheme {
        RoundedButton(text = "Button", onClick = { })
    }
}

@SuppressLint("UnrememberedMutableState")
@Preview
@Composable
private fun ButtonTogglePreview() {

    BMITheme {
        val trueState =  remember {mutableStateOf(true)}
        val falseState = remember {mutableStateOf(false)}
        Row {
            RoundedToggleButton(state = trueState, text = "True", onClick = { })
            EmptyWidth()
            RoundedToggleButton(state = falseState, text = "False", onClick = {})
        }
    }
}