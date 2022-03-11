package com.payu.baas.core.model.responseModels

import com.google.gson.annotations.SerializedName
import com.payu.baas.core.model.model.AdvanceUsageHistory
import com.payu.baas.core.model.model.CurrentUsage




class GetSalaryAdvanceInfoResponse : ApiResponse() {
    @SerializedName("userMessage")
    var userMessage: String? = null

    @SerializedName("systemMessage")
    var systemMessage: String? = null

    @SerializedName("code")
    var code: String? = null

    @SerializedName("advanceAvailable")
    var advanceAvailable: Int? = null

    @SerializedName("currentUsage")
    var currentUsage: CurrentUsage? = null

    @SerializedName("usageHistory")
    var usageHistory: List<AdvanceUsageHistory>? = null

    @SerializedName("blocked")
    var blocked: Boolean? = null

    @SerializedName("active")
    var active: Boolean? = null

}