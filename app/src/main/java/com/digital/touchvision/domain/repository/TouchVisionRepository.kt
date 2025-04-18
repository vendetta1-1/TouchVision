package com.digital.touchvision.domain.repository

import android.media.Image
import com.digital.touchvision.domain.entity.Figure

interface TouchVisionRepository {

    fun voiceActingScreenImage(image: Image)

    fun recognizeFigureInk(/*возможно стоит принимать какой что то*/): Figure
}