package com.digital.touchvision.data.remote.api

import com.digital.touchvision.data.remote.model.AnswerResponse
import com.digital.touchvision.data.remote.model.RequestAnswer
import com.digital.touchvision.data.remote.model.TokenResponse
import retrofit2.http.POST
import retrofit2.http.Body

interface ApiService {

    @POST("https://ngw.devices.sberbank.ru:9443/api/v2/oauth?RqUID=NTgwNDNkY2QtZTQwNy00NGVmLTkxZDYtMmIzYjIxZTUwYTQ3OjlhODM5OWFhLTQyM2MtNDAzZi1iMjEyLWY5MjAxNWMyN2UwZg==&scope=GIGACHAT_API_PERS")
    suspend fun getToken(): TokenResponse

    @POST("https://gigachat.devices.sberbank.ru/api/v1/chat/completions/")
    suspend fun getAnswer(
        @Body requestAnswer: RequestAnswer
    ): AnswerResponse
}