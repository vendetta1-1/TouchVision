package com.digital.touchvision

import android.app.Application
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.digital.touchvision.di.DaggerVisionComponent
import com.digital.touchvision.di.VisionComponent
import com.google.mlkit.vision.digitalink.DigitalInkRecognition
import com.google.mlkit.vision.digitalink.DigitalInkRecognitionModel
import com.google.mlkit.vision.digitalink.DigitalInkRecognitionModelIdentifier
import com.google.mlkit.vision.digitalink.DigitalInkRecognizerOptions
import com.google.mlkit.vision.text.TextRecognition
import com.google.mlkit.vision.text.latin.TextRecognizerOptions

class TouchVisionApp : Application() {

    val component: VisionComponent by lazy {
        DaggerVisionComponent.factory().create(
            application = this,
            textRecognizer = TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS),
            inkRecognizer = DigitalInkRecognition.getClient(
                DigitalInkRecognizerOptions.builder(
                    DigitalInkRecognitionModel.builder(
                        DigitalInkRecognitionModelIdentifier.RU_GESTURE
                    ).build()
                ).build()
            )
        )
    }
}

@Composable
fun getApplicationComponent(): VisionComponent {
    return (LocalContext.current.applicationContext as TouchVisionApp).component
}