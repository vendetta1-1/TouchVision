package com.digital.touchvision.data.repository

import android.graphics.Bitmap
import android.media.Image
import android.util.Log
import com.digital.touchvision.data.remote.api.ApiService
import com.digital.touchvision.data.remote.model.MessageModel
import com.digital.touchvision.data.remote.model.RequestAnswer
import com.digital.touchvision.domain.repository.TouchVisionRepository
import com.google.mlkit.vision.digitalink.DigitalInkRecognizer
import com.google.mlkit.vision.digitalink.Ink
import com.google.mlkit.vision.text.TextRecognizer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class TouchVisionRepositoryImpl @Inject constructor(
    private val textRecognizer: TextRecognizer,
    private val inkRecognizer: DigitalInkRecognizer,
  //  private val apiService: ApiService
) : TouchVisionRepository {

    private val scope = CoroutineScope(Dispatchers.IO)

    private lateinit var token: String

    override fun recognizeTextOnScreen(bitmap: Bitmap): String {
        scope.launch {
  //          token = apiService.getToken().accessToken
        }
        var text = ""
        textRecognizer.process(bitmap, 0)
            .addOnSuccessListener { result ->
                val requestAnswer =
                    RequestAnswer(messages = listOf(MessageModel(content = result.text)))
                scope.launch {
                  //  text = apiService.getAnswer(requestAnswer).choices[0].message.content
                }

            }.addOnFailureListener { e ->
                Log.e(TEXT_TAG, e.message, e)
            }
        return text
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