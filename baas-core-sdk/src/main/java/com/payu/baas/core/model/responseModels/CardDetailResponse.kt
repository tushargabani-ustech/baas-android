package com.payu.baas.core.model.responseModels

import com.google.gson.annotations.SerializedName

class CardDetailResponse : ApiResponse() {
    @SerializedName("userMessage")
    var userMessage: String? = null

    @SerializedName("systemMessage")
    var systemMessage: String? = null

    @SerializedName("code")
    var code: String? = null
    @SerializedName("status")
    var status: String? = null

    @SerializedName("lastFourDigits")
    var lastFourDigits: String? = null

    @SerializedName("allowAtmTransaction")
    var allowAtmTransaction: Boolean? = null

    @SerializedName("allowPOSTransaction")
    var allowPOSTransaction: Boolean? = null
}