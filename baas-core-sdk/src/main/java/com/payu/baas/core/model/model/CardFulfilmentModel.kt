package com.payu.baas.core.model.model

import com.google.gson.annotations.SerializedName
import com.payu.baas.core.model.responseModels.ApiResponse

class CardFulfilmentModel() : ApiResponse() {
    @SerializedName("status")
    var status: String? = null

    @SerializedName("created_at")
    var createdAt: String? = null

}