package com.neomoneybonds.app.model

import com.google.gson.annotations.SerializedName

data class BasketBond(
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: String,
    @SerializedName("bondsQty")
    val bondsQty: Int,
    @SerializedName("rateOfInterest")
    val rateOfInterest: String
){
   fun getBondQuantity():String = bondsQty.toString()
}


