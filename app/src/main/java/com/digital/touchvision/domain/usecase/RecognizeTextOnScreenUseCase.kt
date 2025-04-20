package com.digital.touchvision.domain.usecase

import android.media.Image
import com.digital.touchvision.domain.repository.TouchVisionRepository
import javax.inject.Inject

class RecognizeTextOnScreenUseCase @Inject constructor(
    private val repository: TouchVisionRepository
) {
    operator fun invoke(image: Image) : String {
       return repository.recognizeTextOnScreen(image)
    }
}