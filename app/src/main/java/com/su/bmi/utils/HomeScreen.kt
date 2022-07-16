package com.su.bmi.utils
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
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
import com.su.bmi.widgets.*

@Composable
fun HomeScreen(scaffoldState: ScaffoldState = rememberScaffoldState()) {

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            Toolbar(
                title = stringResource(R.string.app_name),
                navigationIcon = {
                    RoundIconButton(
                        vectorImage = Icons.Outlined.Notifications,
                        onClick = { navigationTo(Screen.Tips) }
                    )
                },
                actions = {
                    RoundIconButton(vectorImage = Icons.Outlined.Person, onClick = { })
                }
            )
        },
        content = {
            Content()
        }
    )
}

@Composable
private fun Content() {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            val maleState = remember { mutableStateOf(true) }
            val femaleState = remember { mutableStateOf(false) }
            RoundedToggleButton(
                state = maleState, text = "Male", onClick = {
                    maleState.value = true
                    femaleState.value = false
                },
                modifier = Modifier
                    .padding(start = 8.dp)
                    .weight(1f)
            )
            RoundedToggleButton(
                state = femaleState, text = "Female", onClick = {
                    femaleState.value = true
                    maleState.value = false
                },
                modifier = Modifier
                    .padding(start = 8.dp)
                    .weight(1f)
            )
        }
        val heightState = remember { mutableStateOf(170) }
        val weightState: MutableState<Int> = remember { mutableStateOf(62) }
        val ageState: MutableState<Int> = remember { mutableStateOf(20) }
        PickerView(
            modifier = Modifier
                .weight(1f)
                .padding(top = 16.dp),
            heightState = heightState,
            weightState = weightState,
            ageState = ageState,
        )
        RoundedButton(
            text = "Calculate",
            onClick = {
                val bmi = BMICalculator(
                    heightState.value,
                    weightState.value
                )
                navigationTo(Screen.Result(bmi))
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        )
    }
}

@Composable
private fun PickerView(
    modifier: Modifier = Modifier,
    heightState: MutableState<Int>,
    weightState: MutableState<Int>,
    ageState: MutableState<Int>
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        HeightSelector(
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 8.dp)
                .fillMaxHeight(),
            heightState = heightState
        )
        Row(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
                .padding(top = 8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            NumberPicker(
                label = "Weight",
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp)
                    .fillMaxHeight(),
                pickerState = weightState
            )
            NumberPicker(
                label = "Age",
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 8.dp)
                    .fillMaxHeight(),
                pickerState = ageState
            )
        }
    }
}

@Composable
private fun HeightSelector(
    modifier: Modifier = Modifier,
    heightState: MutableState<Int>
) {
    val height = buildAnnotatedString {
        withStyle(
            style = SpanStyle(fontSize = 32.sp)
        ) { append(heightState.value.toString()) }
        append(" cm")
    }
    RoundedCard(modifier = modifier) {
        Column(
            modifier = Modifier
                .fillMaxHeight(),
            //.gravity(Alignment.CenterHorizontally),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Height",
                modifier = ColumnChildModifier,
                style = LabelStyle
            )
            Slider(
                value = heightState.value.toFloat(),
                onValueChange = { heightState.value = it.toInt() },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                valueRange = (1f..272f),
                colors = SliderDefaults.colors(
                    activeTrackColor = Red800
                )
            )
            Text(
                text = height,
                modifier = ColumnChildModifier,
                style = LabelStyle
            )
        }
    }
}

@Composable
private fun NumberPicker(
    label: String,
    modifier: Modifier = Modifier,
    pickerState: MutableState<Int>,
    range: IntRange = 1..100
) {
    RoundedCard(modifier = modifier) {
        Column(
            modifier = Modifier,
            verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = label,
                style = LabelStyle,
                modifier = ColumnChildModifier
            )
            Text(
                text = pickerState.value.toString(),
                style = ValueStyle,
                modifier = ColumnChildModifier
            )
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = ColumnChildModifier.fillMaxWidth()
            ) {
                RoundIconButton(vectorImage = Icons.Default.Add, onClick = {
                    if (pickerState.value < range.last) {
                        pickerState.value = pickerState.value + 1
                    }
                })
                RoundIconButton(vectorImage = Icons.Default.Clear, onClick = {
                    if (pickerState.value > range.first) {
                        pickerState.value = pickerState.value - 1
                    }
                })
            }
        }
    }
}

@Preview
@Composable
private fun ScreenPreview() {
    BMITheme {
        HomeScreen()
    }
}


private val LabelStyle = TextStyle(
    color = Color.Black.copy(alpha = 0.6f),
    fontSize = 18.sp
)

private val ValueStyle = TextStyle(
    color = Color.Black.copy(alpha = 0.9f),
    fontSize = 32.sp
)

private val ColumnChildModifier = Modifier.padding(8.dp)

