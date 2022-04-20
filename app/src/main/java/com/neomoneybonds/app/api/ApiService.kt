package com.neomoneybonds.app.api

import com.example.example.Response
import com.example.example.Result
import retrofit2.http.GET




interface ApiService {
    @GET("/basket-detail2")
    suspend fun getBasketDetails(): Response<Result>
}