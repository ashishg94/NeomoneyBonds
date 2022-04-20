package com.example.example

import com.google.gson.annotations.SerializedName


data class Growth(

    @SerializedName("basket") var basket: Basket?,
    @SerializedName("basketbonds") var basketbonds: ArrayList<String>

)