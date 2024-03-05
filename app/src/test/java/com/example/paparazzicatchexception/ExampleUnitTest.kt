package com.example.paparazzicatchexception

import android.widget.TextView
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import app.cash.paparazzi.Paparazzi
import org.junit.Rule
import org.junit.Test

class ExampleUnitTest {
    @get:Rule
    val paparazzi = Paparazzi()

    @Test
    fun launchView() {
        val view = TextView(paparazzi.context).apply { text = "Hello" }
        try {
            paparazzi.gif(view)
        } catch (e: Throwable) {
            println("exception captured view!")
        }
    }

    @Test
    fun launchComposable() {
        val view = ComposeView(paparazzi.context).apply { setContent { Hello() } }
        try {
            paparazzi.gif(view)
        } catch (e: Throwable) {
            println("exception captured composable!")
        }
    }

    @Composable
    private fun Hello() {
        Text("Hello")
    }
}
