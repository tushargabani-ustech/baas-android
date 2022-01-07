package com.payu.baas.core.model.apiModels

import android.content.Context
import com.payu.baas.core.enums.ApiType
import com.payu.baas.core.enums.ContentType
import com.payu.baas.core.enums.RequestMethod
import com.payu.baas.core.enums.TokenType
import com.payu.baas.core.interfaces.SdkCallback
import com.payu.baas.core.model.ApiName
import com.payu.baas.core.model.RequestCreator
import com.payu.baas.core.model.responseModels.ApiResponse
import com.payu.baas.core.model.responseModels.DeleteBeneficiaryResponse
import com.payu.baas.core.model.responseModels.UpdateBeneficiaryResponse
import com.payu.baas.core.network.NetworkHeader
import com.payu.baas.core.util.BaaSConstants

class DeleteBeneficiaryApiModel(
    context: Context,
    requestMap: HashMap<String, Any>,
    sdkCallback: SdkCallback
) : ApiModel(
    context, requestMap, ApiName.DELETE_BENEFICIARY, sdkCallback
) {
    override fun getRelativeUrl(): String = "user/beneficiary"

    override fun getRequestMethod(): RequestMethod = RequestMethod.DELETE
    override fun getApiType(): ApiType = ApiType.POST_LOGIN
    override fun getTokenType(): TokenType = TokenType.ACCESS_TOKEN
    override fun getResponseModel(): ApiResponse = DeleteBeneficiaryResponse()
}