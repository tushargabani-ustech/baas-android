package com.payu.baas.core.model.apiModels

import android.content.Context
import android.util.Log
import com.payu.baas.core.enums.ApiType
import com.payu.baas.core.enums.ContentType
import com.payu.baas.core.enums.RequestMethod
import com.payu.baas.core.enums.TokenType
import com.payu.baas.core.interfaces.SdkCallback
import com.payu.baas.core.model.ApiName
import com.payu.baas.core.model.ErrorResponse
import com.payu.baas.core.model.ResponseModelCreator
import com.payu.baas.core.model.model.BeneficiaryModel
import com.payu.baas.core.model.responseModels.ApiResponse
import com.payu.baas.core.model.responseModels.CreateBeneficiaryResponse
import com.payu.baas.core.model.responseModels.GetUserStateResponse
import com.payu.baas.core.network.NetworkHeader
import com.payu.baas.core.network.NetworkResponseHandler
import com.payu.baas.core.storage.SessionManager
import com.payu.baas.core.util.BaaSConstants

class CreateBeneficiaryApiModel(
    context: Context,
    requestMap: HashMap<String, Any>,
    sdkCallback: SdkCallback
) : ApiModel(
    context, requestMap, ApiName.ADD_BENEFICIARY, sdkCallback
) {
    override fun getRelativeUrl(): String = "user/beneficiary"
    override fun getRequestMethod(): RequestMethod = RequestMethod.POST
    override fun getApiType(): ApiType = ApiType.POST_LOGIN
    override fun getTokenType(): TokenType = TokenType.ACCESS_TOKEN
    override fun getResponseModel(): ApiResponse = CreateBeneficiaryResponse()
    override fun getResponseHandler(): NetworkResponseHandler {
        return object : NetworkResponseHandler {
            override fun onSuccess(response: String) {
                val apiResponse = ResponseModelCreator(this@CreateBeneficiaryApiModel, response).getResponse()
                SessionManager.getInstance(context).beneficiaryIFSCECode = (apiResponse as CreateBeneficiaryResponse).userBeneficiary?.ifsc.toString()
                SessionManager.getInstance(context).beneficiaryId = (apiResponse as CreateBeneficiaryResponse).userBeneficiary?.beneficiaryId.toString()
                this@CreateBeneficiaryApiModel.sdkCallback.onSuccess(apiResponse)
            }
            override fun onError(errorResponse: ErrorResponse) {
                this@CreateBeneficiaryApiModel.sdkCallback.onError(errorResponse)
            }

        }
    }
}