package com.payu.baas.core.model.apiModels

import android.content.Context
import com.payu.baas.core.enums.ApiType
import com.payu.baas.core.enums.RequestMethod
import com.payu.baas.core.enums.TokenType
import com.payu.baas.core.interfaces.SdkCallback
import com.payu.baas.core.enums.ApiName
import com.payu.baas.core.model.responseModels.ApiResponse
import com.payu.baas.core.model.responseModels.UpdateAddressResponse

class UpdateAddressApiModel(
    context: Context,
    requestMap: HashMap<String, Any>,
    sdkCallback: SdkCallback
) : ApiModel(
    context, requestMap, ApiName.UPDATE_USER_ADDRESS, sdkCallback
) {

    override fun getRelativeUrl(): String = "user/address"
    override fun getRequestMethod(): RequestMethod = RequestMethod.PUT
    override fun getApiType(): ApiType = ApiType.POST_LOGIN
    override fun getTokenType(): TokenType = TokenType.ACCESS_TOKEN
    override fun getResponseModel(): ApiResponse = UpdateAddressResponse()
}