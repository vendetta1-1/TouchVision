package com.digital.touchvision.di

import android.app.Application
import com.digital.touchvision.domain.usecase.RecognizeFigureInkUseCase
import com.digital.touchvision.domain.usecase.RecognizeTextOnScreenUseCase
import com.google.mlkit.vision.digitalink.DigitalInkRecognizer
import com.google.mlkit.vision.text.TextRecognizer
import dagger.BindsInstance
import dagger.Component

@Component(
    modules = [DataModule::class]
)
@ApplicationScope
interface VisionComponent {

    fun getTextRecognizer(): TextRecognizer

    fun getRecognizeFigureInkUseCase(): RecognizeFigureInkUseCase

    fun getRecognizeTextOnScreenUseCase(): RecognizeTextOnScreenUseCase

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance application: Application,
            @BindsInstance textRecognizer: TextRecognizer,
            @BindsInstance inkRecognizer: DigitalInkRecognizer
        ): VisionComponent
    }
}