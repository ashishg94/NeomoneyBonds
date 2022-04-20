package com.example.example

import com.google.gson.annotations.SerializedName


data class Response<T>(
    @SerializedName("success") var success: Boolean? = null,
    @SerializedName("status_code") var statusCode: Int? = null,
    @SerializedName("message") var message: String? = null,
    @SerializedName("data") var data: Data<T>?

)