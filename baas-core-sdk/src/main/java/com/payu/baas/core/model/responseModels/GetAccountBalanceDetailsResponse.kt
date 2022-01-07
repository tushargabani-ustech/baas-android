package com.payu.baas.core.model.responseModels

import com.google.gson.annotations.SerializedName

 class GetAccountBalanceDetailsResponse: ApiResponse() {
    @SerializedName("userMessage")
    var userMessage: String? = null

    @SerializedName("systemMessage")
    var systemMessage: String? = null

    @SerializedName("code")
    var code: String? = null
    @SerializedName("prepaidBalance")
    var prepaidBalance: Double? = null

    @SerializedName("advanceBalance")
    var advanceBalance: Double? = null

    @SerializedName("totalAvailableBalance")
    var totalAvailableBalance: Double? = null

    @SerializedName("error")
    var error: String? = null

}