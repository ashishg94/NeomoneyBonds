package com.neomoneybonds.app.api

import com.example.example.Response
import com.example.example.Result
import javax.inject.Inject

class ApiServiceImpl @Inject constructor(private val apiService: ApiService){
    suspend fun getBasketDetailsItem() : Response<Result> =
        apiService.getBasketDetails()

}
