package com.digital.touchvision.di

import com.digital.touchvision.data.repository.TouchVisionRepositoryImpl
import com.digital.touchvision.domain.repository.TouchVisionRepository
import com.google.mlkit.vision.text.TextRecognition
import com.google.mlkit.vision.text.TextRecognizer
import com.google.mlkit.vision.text.latin.TextRecognizerOptions
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @ApplicationScope
    @Binds
    fun bindRepository(impl: TouchVisionRepositoryImpl): TouchVisionRepository

    companion object {
        @Provides
        @ApplicationScope
        fun provideTextRecognizer(): TextRecognizer = TextRecognition.getClient(
            TextRecognizerOptions.DEFAULT_OPTIONS
        )
    }
}