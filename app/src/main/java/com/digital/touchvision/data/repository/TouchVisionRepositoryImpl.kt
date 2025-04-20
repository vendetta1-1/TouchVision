package com.digital.touchvision.data.repository

import android.media.Image
import android.util.Log
import com.digital.touchvision.domain.repository.TouchVisionRepository
import com.google.mlkit.vision.digitalink.DigitalInkRecognizer
import com.google.mlkit.vision.digitalink.Ink
import com.google.mlkit.vision.text.TextRecognizer
import javax.inject.Inject

class TouchVisionRepositoryImpl @Inject constructor(
    private val textRecognizer: TextRecognizer,
    private val inkRecognizer: DigitalInkRecognizer
) : TouchVisionRepository {

    override fun recognizeTextOnScreen(image: Image): String {
        val result = textRecognizer.process(image, 0)
            .addOnSuccessListener { result ->
                val recognizedText = result.text

            }.addOnFailureListener { e ->
                Log.e(TEXT_TAG, e.message, e)
            }
        return ""
    }

    override fun recognizeFigureInk(ink: Ink): String {
        var result = "Unknown"
        inkRecognizer.recognize(ink)
            .addOnSuccessListener { figures ->
                if (figures.candidates.isNotEmpty()) {
                    val topShape = figures.candidates[0].text
                    val confidence = figures.candidates[0].score
                    Log.d(INK_TAG, "фигура: $topShape точность распознования $confidence")
                    result = topShape
                }
            }.addOnFailureListener { e ->
                Log.e(INK_TAG, e.message, e)
            }
        return result
    }

    private companion object {
        const val INK_TAG = "INK_RECOGNITION"
        const val TEXT_TAG = "TEXT_RECOGNITION"
    }
}