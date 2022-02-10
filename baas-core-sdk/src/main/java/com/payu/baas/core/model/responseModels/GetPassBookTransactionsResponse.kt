package com.payu.baas.core.model.responseModels

import com.google.gson.annotations.SerializedName
import com.payu.baas.core.model.responseModels.ApiResponse
import com.payu.baas.core.model.responseModels.GetPassBookTransactionDetails

class GetPassBookTransactionsResponse : ApiResponse() {

    @SerializedName("list")
    var transactionList: ArrayList<GetPassBookTransactionDetails> = arrayListOf()
}