package com.payu.baas.core.model.model

import com.google.gson.annotations.SerializedName
import com.payu.baas.core.model.responseModels.ApiResponse

class AdvanceUsageHistory: ApiResponse() {
    @SerializedName("overdueBalance")
    var overdueBalance: Int? = null

    @SerializedName("advanceUsed")
    var advanceUsed: Int? = null

    @SerializedName("feesCharged")
    var feesCharged: Int? = null

    @SerializedName("latePaymentFees")
    var latePaymentFees: Int? = null

    @SerializedName("paidBack")
    var paidBack: Int? = null

    @SerializedName("startDateTime")
    var startDateTime: String? = null

    @SerializedName("endDateTime")
    var endDateTime: String? = null
}
