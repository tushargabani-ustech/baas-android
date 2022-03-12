package com.payu.baas.core.interfaces

import com.payu.baas.core.model.model.*
import com.payu.baas.core.model.responseModels.*
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.*

interface MockService {
    //OnBoarding
    @POST("user/mobile")
    fun getCurrentOtpData(@Body sendOtp: SendOtp): Call<SendOtpResponse>

    @POST("user/mobile/otp/verify")
    fun getVerifyOtpData(@Body verifyOtp: VerifyOtp): Call<VerifyOtpResponse>

    @POST("user/mobile/otp/verify")
    fun getVerifyOtpErrorData(@Body verifyOtp: VerifyOtp): Call<ApiResponse>

    @POST("user/address")
    fun getSaveAAdressData(@Body saveAddress: SaveAddressRequestModel): Call<SaveAddressResponse>

    @POST("user/address")
    fun getSaveAAdressData(@Body saveAddress: SaveAddressWrongRequestModel): Call<SaveAddressResponse>

    @POST("user/employee/verify")
    fun getEmployeeVerifiactionData(@Body verification: EmploymentVerificationRequestModel): Call<VerifyEmployeeResponse>

    @POST("user/employee/verify")
    fun getEmployeeVerifiactionData(@Body verification: EmploymentVerificationWrongTypeRequestModel): Call<VerifyEmployeeResponse>

    @POST("user/pan-validate")
    fun getValidatePanData(@Body verification: ValidatePanRequestModel): Call<PanValidateResponse>

    @POST("passcode?newPasscode=1111&oldPasscode=8989")
    fun getSetPasscodeData(): Call<SetPasswordResponse>

    @POST("login")
    fun getLoginData(@Body requestModel: LoginRequestModel): Call<LoginResponse>

    //Home Screen
    @GET("account/balance")
    fun getAccountBalanceData(): Call<GetAccountBalanceDetailsResponse>

    @GET("ransactions?startDate=2020-05-06&endDate=2020-07-06&accountType=saving&debitIndicator=Debit")
    fun getTransactionDetailsData(): Call<GetTransactionDetailsResponse>

    @GET("account/details")
    fun getAccountDetailsData(): Call<GetAccountDetailsResponse>

    @GET("user/details")
    fun getUserDetailsData(): Call<GetUserDetailsResponse>

    @PUT("user/details")
    fun getUpdateUserEmailData(@Body requestModel: UpdateUserEmailRequestModel): Call<UpdateUserDetailsResponse>

    @PUT("user/details")
    fun getUpdateUserMobileData(@Body requestModel: UpdateUserMobileRequestModel): Call<UpdateUserDetailsResponse>

    @PUT("user/details")
    fun getUpdateUserAddressData(@Body requestModel: UpdateUserAddressRequestModel): Call<UpdateUserDetailsResponse>

    //Benificiary Apis
    @GET("transaction/charges")
    fun getTransferChargesData(): Call<GetTransactionChargesResponse>

    @GET("user/beneficiary?page=2&size=5&sort=asc")
    fun getUserBenificiaryData(): Call<GetBeneficiaryResponse>

    @GET("user/beneficiary/recent?page=1&size=2&sort=asc")
    fun getRecentUserBenificiaryData(): Call<GetRecentBeneficiaryResponse>

    @POST("user/beneficiary")
    fun getCreateBenificiaryData(@Body requestModel: CreateAndUpdateBenificiaryRequestModel): Call<CreateBeneficiaryResponse>

    @POST("user/T1234/beneficiary")
    fun getUpdateUserBenificiaryData(@Body requestModel: CreateAndUpdateBenificiaryRequestModel): Call<UpdateBeneficiaryResponse>

    @POST("user/beneficiary/bank-transfer")
    fun getUpdateUserBenificiaryBankTransferData(@Body requestModel: UserBenificiaryBankTransferRequestModel): Call<BeneficiaryBankTransferResponse>

    @DELETE("user/T1234/beneficiary")
    fun getDeleteUserBenificiaryData(): Call<DeleteBeneficiaryResponse>

    // salary advance info
    @GET("user/salaryAdvanceinfo")
    fun getSalaryAdvanceinfoData(): Call<GetSalaryAdvanceInfoResponse>

    //KYC SDK
    @POST("kyc/selfie")
    fun getKycSelfieData(@Body requestModel: MultipartBody.Part): Call<KYCSelfieResponse>

    @POST("kyc/aadhaar")
    fun getKycAadharData(@Body requestModel: KycAadharRequestModel): Call<KYCAadharResponse>

    @POST("kyc/location")
    fun getKycLocationData(@Body requestModel: KycLocationRequestModel): Call<KYCLocationResponse>

    // Card apis
    @GET("card/image")
    fun getCardImageData(): Call<CardImageResponse>

    @GET("card")
    fun getCardDetailsData(): Call<CardDetailResponse>

    @GET("card/fulfillment")
    fun getCardFulfillmentData(): Call<CardFulfilmentResponse>

    @POST("card/transaction-modes")
    fun setCardTransactionModeData(@Body requestModel: GetTransactionModeResponse): Call<SetTransactionModeResponse>

    @GET("transaction/modes")
    fun getCardTransactionModeData(): Call<GetTransactionModeResponse>

    @POST("card/limits")
    fun setCardLimitsData(@Body requestModel: GetLimitsResponse): Call<SetLimitResponse>

    @GET("card/limits")
    fun getCardLimitsData(): Call<GetLimitsResponse>

    @PUT("card/block")
    fun setBlockCardData(@Body requestModel: BlockCardRequestModel): Call<BlockCardResponse>

    @PUT("card/unblock")
    fun setUnBlockCardData(): Call<UnblockCardResponse>

    @PUT("card/set-pin")
    fun setCardPinData(@Body requestModel: SetPinRequestModel): Call<CardSetPinResponse>

    @PUT("card/update-pin?pin_status=true")
    fun updateCardPinStatusData(): Call<UpdateCardPinSetStatusResponse>

    @PUT("card/get-pin-status")
    fun getCardPinData(): Call<GetCardPinStatusResponse>
}