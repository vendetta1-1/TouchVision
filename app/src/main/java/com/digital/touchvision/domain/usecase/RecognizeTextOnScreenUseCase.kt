package com.digital.touchvision.domain.usecase

import android.graphics.Bitmap
import com.digital.touchvision.domain.repository.TouchVisionRepository
import javax.inject.Inject

class RecognizeTextOnScreenUseCase @Inject constructor(
    private val repository: TouchVisionRepository
) {
    operator fun invoke(bitmap: Bitmap) : String {
       return repository.recognizeTextOnScreen(bitmap)
    }
}