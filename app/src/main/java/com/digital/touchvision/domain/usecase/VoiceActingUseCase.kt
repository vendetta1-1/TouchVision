package com.digital.touchvision.domain.usecase

import android.media.Image
import com.digital.touchvision.domain.repository.TouchVisionRepository
import javax.inject.Inject

class VoiceActingUseCase @Inject constructor(
    private val repository: TouchVisionRepository
) {
    fun invoke(image: Image) {
        repository.voiceActingScreenImage(image)
    }
}