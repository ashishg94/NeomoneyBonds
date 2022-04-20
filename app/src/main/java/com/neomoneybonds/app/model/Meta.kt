package com.example.example

import com.google.gson.annotations.SerializedName


data class Meta(

    @SerializedName("count") var count: Int? ,
    @SerializedName("size") var size: Int? ,
    @SerializedName("limit") var limit: Int? ,
    @SerializedName("offset") var offset: Int?,
    @SerializedName("order_by") var orderBy: String?,
    @SerializedName("sort_by") var sortBy: String?

)