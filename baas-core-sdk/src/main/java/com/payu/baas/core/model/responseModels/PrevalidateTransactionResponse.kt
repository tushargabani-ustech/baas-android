package com.payu.baas.core.model.responseModels

import com.google.gson.annotations.SerializedName

class PrevalidateTransactionResponse : ApiResponse() {
    @SerializedName("userMessage")
    var userMessage: String? = null

    @SerializedName("systemMessage")
    var systemMessage: String? = null

    @SerializedName("code")
    var code: String? = null

    @SerializedName("maxAmountTransfer")
    var maxAmountTransfer: Double? = null

    @SerializedName("charges")
    var chargedAmount: Double? = null

    @SerializedName("advanceUseFees")
    var advanceChargeAmount: Double? = null
}