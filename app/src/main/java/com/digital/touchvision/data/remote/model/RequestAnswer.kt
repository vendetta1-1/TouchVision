package com.digital.touchvision.data.remote.model

import com.google.gson.annotations.SerializedName

data class RequestAnswer(
    val model: String = "GigaChat",
    val messages: List<MessageModel>,
    val stream: Boolean = false,
    @SerializedName("repetition_penalty")
    val repetitionPenalty: Int = 1
)

data class MessageModel(
    val role: String = "user",
    val content: String
)

