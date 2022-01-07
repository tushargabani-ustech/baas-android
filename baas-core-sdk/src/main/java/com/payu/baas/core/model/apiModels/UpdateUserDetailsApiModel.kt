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

class UpdateUserDetailsApiModel(
    context: Context, apiName: ApiName,
    requestMap: HashMap<String, Any>,
    sdkCallback: SdkCallback
) : ApiModel(
    context, requestMap, apiName, sdkCallback
) {

    override fun getRelativeUrl(): String = "user/details"
    override fun getRequestMethod(): RequestMethod = RequestMethod.POST
//    override fun getContentType(): ContentType = ContentType.APPLICATION_JSON
    override fun getApiType(): ApiType = ApiType.POST_LOGIN
    override fun getTokenType(): TokenType = TokenType.ACCESS_TOKEN
//    override fun getAdditionaHeader(): NetworkHeader {
//        return NetworkHeader().apply {
//            SessionManager.getInstance(context).loginAccessToken?.let {
//                put(
//                    BaaSConstants.BS_KEY_ACCESS_TOKEN,
//                    it
//                )
//            }
//            SessionManager.getInstance(context).deviceBindingId?.let {
//                put(BaaSConstants.BS_KEY_DEVICE_BINDING_ID, it)
//            }
//        }
//    }

    override fun getResponseModel(): ApiResponse = UpdateUserDetailsResponse()
}