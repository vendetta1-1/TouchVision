package com.digital.touchvision.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.digital.touchvision.getApplicationComponent
import com.digital.touchvision.presentation.root.RootScreen
import com.digital.touchvision.presentation.theme.TouchVisionTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val component = getApplicationComponent()
            val viewModelFactory = component.getViewModelFactory()
            TouchVisionTheme {
                RootScreen(viewModelFactory = viewModelFactory)
            }
        }
    }
}