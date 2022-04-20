package com.example.example

import com.google.gson.annotations.SerializedName


data class Result(
    @SerializedName("safety") var safety: List<BasketDetailResponse>,
    @SerializedName("growth") var growth: List<BasketDetailResponse>
)