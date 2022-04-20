package com.example.example

import com.google.gson.annotations.SerializedName


data class Basket(
    @SerializedName("basket_id") var basketId: Int?,
    @SerializedName("basket_code") var basketCode: String?,
    @SerializedName("name") var name: String?,
    @SerializedName("tenure") var tenure: Int?,
    @SerializedName("avg_coupon_rate") var avgCouponRate: Double?,
    @SerializedName("grand_total") var grandTotal: Int? = null,
    @SerializedName("grand_variance_total") var grandVarianceTotal: String?,
    @SerializedName("risk_profile_id") var riskProfileId: Int?,
    @SerializedName("risk_profile") var riskProfile: String?
) {
    fun getRateOfInterest(): Double? {
        return avgCouponRate
    }

    fun getTenureValue(): String {
        return "${tenure}M"
    }

    fun getGrandValue(): String {
        return "Rs.${grandTotal}"
    }
        fun getTotalGrandValue(): String {
            return "Rs.${grandVarianceTotal}"
        }


    }
