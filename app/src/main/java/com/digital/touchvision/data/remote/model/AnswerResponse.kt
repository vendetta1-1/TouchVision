package com.digital.touchvision.data.remote.model

data class AnswerResponse (
    val choices: List<Choice>
)
data class Choice(
    val message: MessageModel
)