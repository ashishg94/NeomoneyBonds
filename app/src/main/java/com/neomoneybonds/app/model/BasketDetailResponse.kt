package com.example.example

import com.google.gson.annotations.SerializedName
import com.neomoneybonds.app.model.BasketBond


data class BasketDetailResponse(
    @SerializedName("basket") var basket: Basket? = null,
    @SerializedName("basketbonds") var basketbonds: List<BasketBond>
){
    var isSelected:Boolean=false
}