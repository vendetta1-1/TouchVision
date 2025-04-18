package com.digital.touchvision.domain.usecase

import com.digital.touchvision.domain.entity.Figure
import com.digital.touchvision.domain.repository.TouchVisionRepository
import javax.inject.Inject

class RecognizeFigureInkUseCase @Inject constructor(
    private val repository: TouchVisionRepository
) {
    operator fun invoke(): Figure {
        return repository.recognizeFigureInk()
    }
}