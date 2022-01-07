package com.payu.baas.core.model.apiModels

import android.content.Context
import com.payu.baas.core.enums.ApiType
import com.payu.baas.core.enums.RequestMethod
import com.payu.baas.core.enums.TokenType
import com.payu.baas.core.interfaces.SdkCallback
import com.payu.baas.core.model.ApiName
import com.payu.baas.core.model.responseModels.AddKYCResultsResponse
import com.payu.baas.core.model.responseModels.ApiResponse

class AddKYCResultApiModel(
    context: Context,
    requestMap: HashMap<String, Any>,
    sdkCallback: SdkCallback
) : ApiModel(
    context, requestMap, ApiName.KYC_RESULTS, sdkCallback
) {
    override fun getRelativeUrl(): String = "kyc/results"
    override fun getRequestMethod(): RequestMethod = RequestMethod.POST
    override fun getApiType(): ApiType = ApiType.PRE_LOGIN
    override fun getTokenType(): TokenType = TokenType.ACCESS_TOKEN
    override fun getResponseModel(): ApiResponse = AddKYCResultsResponse()
}