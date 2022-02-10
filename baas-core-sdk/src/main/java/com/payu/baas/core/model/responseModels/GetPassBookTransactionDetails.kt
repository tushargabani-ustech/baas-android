package com.payu.baas.core.model.responseModels

import com.google.gson.annotations.SerializedName

class GetPassBookTransactionDetails {
    @SerializedName("mode")
    var mode: String? = null

    @SerializedName("amount")
    var amount: String? = 0.0.toString()

    @SerializedName("status")
    var status: String? = null

    @SerializedName("debitCreditIndicator")
    var debitCreditIndicator: String? = null

    @SerializedName("date")
    var date: String? = null

    @SerializedName("icon_url")
    var iconUrl: String? = null

    @SerializedName("label")
    var label: String? = null

}