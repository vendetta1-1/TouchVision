package com.digital.touchvision.domain.usecase

import com.digital.touchvision.domain.repository.TouchVisionRepository
import com.google.mlkit.vision.digitalink.Ink
import javax.inject.Inject

class RecognizeFigureInkUseCase @Inject constructor(
    private val repository: TouchVisionRepository
) {
    operator fun invoke(ink: Ink): String {
        return repository.recognizeFigureInk(ink)
    }
}