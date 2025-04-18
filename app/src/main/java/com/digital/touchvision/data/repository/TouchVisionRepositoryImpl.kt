package com.digital.touchvision.data.repository

import android.media.Image
import com.digital.touchvision.domain.entity.Figure
import com.digital.touchvision.domain.repository.TouchVisionRepository
import com.google.mlkit.vision.text.TextRecognizer
import javax.inject.Inject

class TouchVisionRepositoryImpl @Inject constructor(
    private val recognizer: TextRecognizer
) : TouchVisionRepository {

    override fun voiceActingScreenImage(image: Image) {
        val result = recognizer.process(image, 0)
            .addOnSuccessListener {

            }.addOnFailureListener {

            }
    }

    override fun recognizeFigureInk(): Figure {
        //здесь будем распозновать фигуру нарисованную пользователем и возращать Figure
        return Figure.Unknown
    }

}