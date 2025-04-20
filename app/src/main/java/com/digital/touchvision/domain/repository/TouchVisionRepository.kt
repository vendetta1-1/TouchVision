package com.digital.touchvision.domain.repository

import android.media.Image
import com.google.mlkit.vision.digitalink.Ink

interface TouchVisionRepository {

    fun recognizeTextOnScreen(image: Image): String

    fun recognizeFigureInk(ink: Ink): String
}