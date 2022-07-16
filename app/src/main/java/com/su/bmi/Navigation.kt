package com.su.bmi

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

sealed class Screen {
    object Home : Screen()
    data class Info(val bmi: BMICalculator) : Screen()
    data class Result(val bmi: BMICalculator) : Screen()
    object Tips : Screen()
}

object ComposeStatus {
    var curentScreen by mutableStateOf<Screen>(Screen.Home)
    var previousScreen by mutableStateOf<Screen?>(null)
}

fun navigationTo(destination: Screen) {
    ComposeStatus.curentScreen = destination
}
