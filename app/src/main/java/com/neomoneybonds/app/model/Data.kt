package com.example.example

import com.google.gson.annotations.SerializedName


data class Data<T>(
    @SerializedName("meta") var meta: Meta?,
    @SerializedName("result") var result: T,
)