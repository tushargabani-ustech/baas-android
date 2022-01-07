package com.payu.baas.core.model.apiModels

import android.content.Context
import com.payu.baas.core.enums.ApiType
import com.payu.baas.core.enums.ContentType
import com.payu.baas.core.enums.RequestMethod
import com.payu.baas.core.enums.TokenType
import com.payu.baas.core.interfaces.SdkCallback
import com.payu.baas.core.model.ApiName
import com.payu.baas.core.model.responseModels.ApiResponse
import com.payu.baas.core.model.responseModels.UpdatePasswordResponse
import com.payu.baas.core.network.NetworkHeader
import com.payu.baas.core.util.BaaSConstants

class UpdatePasswordApiModel(
    context: Context,
    requestMap: HashMap<String, Any>,
    sdkCallback: SdkCallback
) : ApiModel(
    context, requestMap, ApiName.UPDATE_PASSWORD, sdkCallback
) {
    override fun getRelativeUrl(): String =
        "changePasscode?${BaaSConstants.BS_KEY_NEW_PASSWORD}=${requestMap[BaaSConstants.BS_KEY_NEW_PASSWORD]}&${BaaSConstants.BS_KEY_OLD_PASSWORD}=${
            requestMap[BaaSConstants.BS_KEY_OLD_PASSWORD]
        }"

    override fun getRequestMethod(): RequestMethod = RequestMethod.PUT
    override fun getApiType(): ApiType = ApiType.PRE_LOGIN
    override fun getTokenType(): TokenType = TokenType.ACCESS_TOKEN
    override fun getRequestData(): String = ""

    override fun getResponseModel(): ApiResponse = UpdatePasswordResponse()
}