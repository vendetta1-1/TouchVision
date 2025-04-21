package com.digital.touchvision.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.digital.touchvision.data.recognition.VisionService
import com.digital.touchvision.getApplicationComponent
import com.digital.touchvision.presentation.home.HomeScreenState
import com.digital.touchvision.presentation.root.RootScreen
import com.digital.touchvision.presentation.theme.TouchVisionTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val component = getApplicationComponent()
            val viewModelFactory = component.getViewModelFactory()
            TouchVisionTheme {
                RootScreen(viewModelFactory = viewModelFactory) {
                    when (it) {
                        HomeScreenState.End -> {
                            startService(VisionService.newIntent(this))
                        }

                        HomeScreenState.Initial -> {
                            startService(VisionService.newIntent(this))
                        }

                        HomeScreenState.Start -> {
                            stopService(VisionService.newIntent(this))
                        }
                    }
                }
            }
        }
    }
}