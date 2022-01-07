package com.payu.baas.core.model.apiModels

import android.content.Context
import com.payu.baas.core.enums.ApiType
import com.payu.baas.core.enums.ContentType
import com.payu.baas.core.enums.RequestMethod
import com.payu.baas.core.enums.TokenType
import com.payu.baas.core.interfaces.SdkCallback
import com.payu.baas.core.model.ApiName
import com.payu.baas.core.model.ErrorResponse
import com.payu.baas.core.model.ResponseModelCreator
import com.payu.baas.core.model.responseModels.*
import com.payu.baas.core.network.NetworkHeader
import com.payu.baas.core.network.NetworkResponseHandler
import com.payu.baas.core.storage.SessionManager
import com.payu.baas.core.util.BaaSConstants

class GetAccountDetailsApiModel(
    context: Context,
    requestMap: HashMap<String, Any>,
    sdkCallback: SdkCallback
) : ApiModel(context, requestMap, ApiName.GET_ACCOUNT_DETAILS, sdkCallback) {

    override fun getRelativeUrl(): String = "account/details"
    override fun getRequestMethod(): RequestMethod = RequestMethod.GET
    override fun getApiType(): ApiType = ApiType.POST_LOGIN
    override fun getTokenType(): TokenType = TokenType.ACCESS_TOKEN
    override fun getRequestData(): String = ""
    override fun getResponseModel(): ApiResponse = GetAccountDetailsResponse()
}