package com.payu.baas.core.model

import android.os.Handler
import android.os.Looper
import com.payu.baas.core.enums.ContentType
import com.payu.baas.core.enums.RequestMethod
import com.payu.baas.core.enums.TokenType
import com.payu.baas.core.model.apiModels.ApiModel
import com.payu.baas.core.util.BaaSConstants
import com.payu.baas.core.util.Utils
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import okio.IOException
import java.io.File


class ApiExecutor(val apiModel: ApiModel, val apiHandler: ApiHandler?) {

    fun call() {

        if (Utils.isInternetAvailable(apiModel.context)) {

            val client = OkHttpClient()
            val requestBody: RequestBody
            if (apiModel.getContentType() == ContentType.APPLICATION_JSON) {
                requestBody = apiModel.getRequestData()
                    .toRequestBody(apiModel.getContentType().getValue().toMediaTypeOrNull())
            } else {
                var file = File(apiModel.requestMap[BaaSConstants.BS_KEY_LIVE_PHOTO].toString())
                requestBody =
                    MultipartBody.Builder().setType(MultipartBody.FORM)
                        .addFormDataPart(
                            BaaSConstants.BS_KEY_LIVE_PHOTO,
                            apiModel.requestMap[BaaSConstants.BS_KEY_KARZA_SELFIE_NAME].toString(),
                            /*RequestBody.create(
                                apiModel.getContentType().getValue().toMediaTypeOrNull(),
                                file
                            )*/
                            file
                                .asRequestBody(
                                    apiModel.getContentType().getValue().toMediaTypeOrNull()
                                )
                        ).build()
            }

            val requestBuilder: Request.Builder =
                if (apiModel.getTokenType() == TokenType.KARZA_TOKEN) {
                    Request.Builder()
                        .url(apiModel.getRelativeUrl())
                } else {
                    Request.Builder()
                        .url(Utils.getAbsoluteUrl(apiModel.getRelativeUrl()))
                }
            if (apiModel.getRequestMethod() != RequestMethod.GET)
                requestBuilder.method(apiModel.getRequestMethod().name, requestBody)

            val header = apiModel.getHeader()
            if (!header.isNullOrEmpty())
                header.forEach { (key, value) -> requestBuilder.addHeader(key, value) }

            val request = requestBuilder.build()
            client.newCall(request).enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    Handler(Looper.getMainLooper()).post {
                        apiHandler?.handleErrorResponse(e.message)
                    }
                }
                override fun onResponse(call: Call, response: Response) {
                    Handler(Looper.getMainLooper()).post {
                        if(response!=null && response.code!=null && response.body!=null)
                        apiHandler?.handleResponse(response.code, response.body?.string())
                    }
                }
            })

        } else {
            apiHandler?.handleResponse(
                BaaSConstants.NO_INTERNET_ERROR_CODE,
                BaaSConstants.NO_INTERNET_ERROR_MESSAGE
            )
        }


    }


}