package com.digital.touchvision.domain.repository

import android.graphics.Bitmap
import com.google.mlkit.vision.digitalink.Ink

interface TouchVisionRepository {

    fun recognizeTextOnScreen(bitmap: Bitmap): String

    fun recognizeFigureInk(ink: Ink): String
}