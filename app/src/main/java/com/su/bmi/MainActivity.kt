package com.su.bmi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.su.bmi.ui.theme.BMITheme
import com.su.bmi.utils.HomeScreen
import com.su.bmi.utils.InfoScreen
import com.su.bmi.utils.ResultScreen
import com.su.bmi.utils.TipsScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BMITheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    ComposeApp()
                }
            }
        }
    }
}

@Composable
fun ComposeApp() {
   BMITheme {
       AppContent()
   }
}

@Composable
fun AppContent() {
    Crossfade(ComposeStatus.curentScreen) { screen ->
        Surface(color = MaterialTheme.colors.background) {
            when (screen) {
                is Screen.Home -> HomeScreen()
                is Screen.Info -> InfoScreen(bmi = screen.bmi)
                is Screen.Result -> ResultScreen(bmi = screen.bmi)
                is Screen.Tips -> TipsScreen()
            }
        }
    }
}