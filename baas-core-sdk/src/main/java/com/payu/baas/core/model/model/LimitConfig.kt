package com.payu.baas.core.model.model

import com.google.gson.annotations.SerializedName
import com.payu.baas.core.model.responseModels.ApiResponse


class LimitConfig: ApiResponse()  {
    @SerializedName("channel")
    var channel: String? = null

    @SerializedName("perTransaction")
    var perTransaction: Long? = null

    @SerializedName("daily")
    var daily: Long? = null

}
