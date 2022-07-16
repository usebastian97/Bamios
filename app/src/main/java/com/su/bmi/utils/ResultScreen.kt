package com.su.bmi.utils

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.su.bmi.BMICalculator
import com.su.bmi.R
import com.su.bmi.Screen
import com.su.bmi.navigationTo
import com.su.bmi.ui.theme.BMITheme
import com.su.bmi.ui.theme.Red800
import com.su.bmi.widgets.RoundIconButton
import com.su.bmi.widgets.RoundedButton
import com.su.bmi.widgets.Toolbar

@Composable
fun ResultScreen(
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    bmi: BMICalculator
) {
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            Toolbar(title = stringResource(R.string.bmi_results),
                navigationIcon = {
                    RoundIconButton(
                        vectorImage = Icons.Outlined.Notifications,
                        onClick = { navigationTo(Screen.Home) }
                    )
                },
                actions = {
                    RoundIconButton(vectorImage = Icons.Outlined.Person, onClick = {})
                }
            )
        },
        content = {
            Content(bmi)
        }
    )
}

@Composable
private fun Content(result: BMICalculator) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround
    ) {
        val childModifier = Modifier.align(Alignment.CenterHorizontally)
        Card(
            shape = CircleShape,
            elevation = 4.dp,
            backgroundColor = MaterialTheme.colors.background,
            modifier = childModifier
        ) {
            Card(
                shape = CircleShape,
                modifier = Modifier.padding(32.dp),
                backgroundColor = Red800
            ) {
                Box(
                    modifier = Modifier
                        .background(color = MaterialTheme.colors.background, shape = CircleShape)
                        .size(112.dp)
                        .padding(8.dp)
                        .align(Alignment.CenterHorizontally),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = result.bmiString,
                        style = TextStyle(
                            fontWeight = FontWeight.SemiBold,
                            color = Color.Black.copy(alpha = 0.8f),
                            fontSize = 32.sp
                        )
                    )
                }
            }
        }
        Text(
            style = textStyle.copy(
                fontSize = 18.sp
            ),
            text = buildAnnotatedString {
                append("You have ")
                withStyle(
                    style = SpanStyle(
                        color = Red800,
                        fontWeight = FontWeight.Bold
                    )
                ) {
                    append(result.result)
                }
                append(" body weight!")
            },
            modifier = childModifier
        )
        RoundedButton(
            text = stringResource(R.string.details).uppercase(),
            onClick = { navigationTo(Screen.Info(result)) },
            modifier = childModifier.width(120.dp),
            backGroundColor = Red800,
            contentColor = Color.White
        )
    }
}

@Preview
@Composable
private fun ScreenPreview() {
    BMITheme {
        ResultScreen(bmi = BMICalculator(202, 62))
    }
}