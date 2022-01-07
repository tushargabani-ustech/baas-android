package com.payu.baasSampleApp.interfaces

import com.payu.baas.core.model.responseModels.SendOtpResponse
import retrofit2.Call
import retrofit2.http.POST

interface SendOtpService{
    @POST("user/mobile/8544941620")
    fun getCurrentOtpData(): Call<SendOtpResponse>
}