package com.digital.touchvision.di

import android.app.Application
import com.digital.touchvision.domain.usecase.RecognizeFigureInkUseCase
import com.digital.touchvision.domain.usecase.RecognizeTextOnScreenUseCase
import com.digital.touchvision.presentation.factory.VisionViewModelFactory
import com.google.mlkit.vision.digitalink.DigitalInkRecognizer
import com.google.mlkit.vision.text.TextRecognizer
import dagger.BindsInstance
import dagger.Component

@Component(
    modules = [DataModule::class, ViewModelModule::class]
)
@ApplicationScope
interface VisionComponent {

    fun getRecognizeFigureInkUseCase(): RecognizeFigureInkUseCase

    fun getRecognizeTextOnScreenUseCase(): RecognizeTextOnScreenUseCase

    fun getViewModelFactory(): VisionViewModelFactory

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance application: Application,
            @BindsInstance textRecognizer: TextRecognizer,
            @BindsInstance inkRecognizer: DigitalInkRecognizer
        ): VisionComponent
    }
}