package com.su.bmi

import java.math.RoundingMode
import java.text.DecimalFormat
import kotlin.math.pow

data class BMICalculator(val height: Int, val weight: Int) {

    var bmi: Double = 0.0

    init {
        bmi = (weight / (height.toDouble() / 100).pow(2.0)).roundOff()
    }

    private fun Double.roundOff(): Double {
        val df = DecimalFormat("#.#")
        df.roundingMode = RoundingMode.CEILING
        return df.format(this).toDouble()
    }

    val bmiString: String
        get() = bmi.toString()

    val result: String
        get() = when {
            bmi < 18.5 -> "Underweight"
            bmi in (18.5..24.9) -> "Normal"
            else -> "Overweight"
        }

    val bmiPercentage: Double
        get() {
            return bmi / 29.9 * 100
        }
}
