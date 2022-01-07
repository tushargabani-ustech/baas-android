package com.payu.baas.core.model.model

import com.google.gson.annotations.SerializedName
import com.payu.baas.core.model.responseModels.ApiResponse

class CurrentUsage: ApiResponse() {

    @SerializedName("advanceAvailable")
    var advanceAvailable: Int? = null

    @SerializedName("advanceUsed")
    var advanceUsed: Int? = null

    @SerializedName("feesCharged")
    var feesCharged: Int? = null

    @SerializedName("startDateTime")
    var startDateTime: String? = null

    @SerializedName("endDateTime")
    var endDateTime: String? = null

    @SerializedName("paidBack")
    var paidBack: Int? = null

    @SerializedName("dueDate")
    var dueDate: String? = null

    @SerializedName("latePaymentFees")
    var latePaymentFees: Int? = null
}
