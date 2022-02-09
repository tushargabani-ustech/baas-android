package com.payu.baasSampleApp

import android.app.AlertDialog
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.clevertap.android.sdk.CleverTapAPI
import com.payu.baas.core.BaaSSDK
import com.payu.baas.core.interfaces.SdkCallback
import com.payu.baas.core.model.ApiDetails
import com.payu.baas.core.model.ApiName
import com.payu.baas.core.model.ApiParams
import com.payu.baas.core.model.ErrorResponse
import com.payu.baas.core.model.responseModels.*
import com.payu.baas.core.storage.SessionManager
import com.payu.baas.core.util.BaaSConstants
import com.payu.baas.core.util.JsonUtils
import com.payu.baas.core.util.Utils
import com.payu.baas.core.view.KarzaActivity
import com.payu.baasSampleApp.databinding.ActivityMainBinding
import org.json.JSONArray
import org.json.JSONObject
import java.io.*
import java.util.*


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var cleverTapDefaultInstance: CleverTapAPI? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        cleverTapDefaultInstance = CleverTapAPI.getDefaultInstance(applicationContext)
        Utils.identifyUsers()
        CleverTapAPI.getDefaultInstance(applicationContext)?.onUserLogin(Utils.profileUpdate)
//           java.util.logging.Logger.getLogger("test: ", BaasEncryption.decrypt(BaasEncryption.encrypt("TusharGabani@123")).toString())
    }

    fun sendOTP(view: View) {
        val apiParams = ApiParams().apply {
            mobileNumber = binding.etMobile.text.toString().trim()
        }
        callAPI(ApiName.SEND_OTP, apiParams)
    }

    fun verifyOTP(view: View) {
        val apiParams = ApiParams().apply {
            mobile = binding.etMobile.text.toString().trim()
            code = binding.etOTP.text.toString().trim()
        }

        callAPI(ApiName.VERIFY_OTP, apiParams)
    }

    fun verifyEmployee(view: View) {
        val apiParams = ApiParams().apply {
            panNumber = binding.etPancard.text.toString().trim()
            employeeId = binding.etEmpId.text.toString().trim()
            mobile = binding.etMobile.text.toString().trim()
        }
        callAPI(ApiName.VERIFY_EMPLOYEE, apiParams)
    }

    fun saveAddress(view: View) {
        val apiParams = ApiParams().apply {
            panNumber = binding.etPancard.text.toString().trim()
            employeeId = binding.etEmpId.text.toString().trim()
            mobile = binding.etMobile.text.toString().trim()
            title = "Mr"
            firstName = "Tushar"
            lastName = "Gabani"
            gender = "male"
            dob = "1986-08-06"
            email = "Tushar.Gabhan@ustechsolutions.com"
            country = "India"
            countryCode = "+91"
            addressLine1 = "Royal square"
            addressLine2 = "Utran"
            city = "Surat"
            pinCode = "394105"
            state = "Gujarat"
        }
        callAPI(ApiName.SAVE_ADDRESS, apiParams)
    }


    fun setPasscode(view: View) {
        val apiParams = ApiParams().apply {
            password = binding.etPasscode.text.toString().trim()
        }
        callAPI(ApiName.SET_PASSWORD, apiParams)
    }


    fun login(view: View) {

        val apiParams = ApiParams().apply {
            username = binding.etMobile.text.toString().trim()
            password = binding.etPasscode.text.toString().trim()
        }
        callAPI(ApiName.LOGIN, apiParams)

    }

    fun getUserState(view: View) {

        val apiParams = ApiParams().apply {
            mobileNumber = binding.etMobile.text.toString().trim()
        }
        callAPI(ApiName.GET_USER_STATE, apiParams)
    }


    fun validatePan(view: View) {
        val apiParams = ApiParams().apply {
            panNumber = binding.etPancard.text.toString().trim()
        }
        callAPI(ApiName.PAN_VALIDATE, apiParams)
    }

    fun updatePasscode(view: View) {
        val apiParams = ApiParams().apply {
            oldPassword = binding.etPasscode.text.toString().trim()
            newPassword = binding.etNewPasscode.text.toString().trim()
        }
        callAPI(ApiName.UPDATE_PASSWORD, apiParams)
    }

    fun card_image(view: View) {
        val apiParams = ApiParams()
        callAPI(ApiName.CARD_IMAGE, apiParams)

    }

    fun card_details(view: View) {
        val apiParams = ApiParams()
        callAPI(ApiName.CARD_DETAILS, apiParams)

    }

    fun card_fulfilment(view: View) {
        val apiParams = ApiParams()
        callAPI(ApiName.CARD_FULFILMENT, apiParams)

    }

    fun get_transaction_mode(view: View) {
        val apiParams = ApiParams()
        callAPI(ApiName.GET_TRANSACTION_MODE, apiParams)
    }

    fun getLimits(view: View) {
        val apiParams = ApiParams()
        callAPI(ApiName.GET_LIMITS, apiParams)
    }

    fun block_card(view: View) {
        val apiParams = ApiParams().apply {
            reason = "Temp"
        }
        callAPI(ApiName.BLOCK_CARD, apiParams)
    }

    fun unblock_card(view: View) {
        val apiParams = ApiParams()
        callAPI(ApiName.UNBLOCK_CARD, apiParams)
    }

    fun card_setPin(view: View) {
        val apiParams = ApiParams().apply {
            redirect_link = "http://www.google.com"
        }
        callAPI(ApiName.CARD_SET_PIN, apiParams)
    }

    fun setLimits(view: View) {
        val transactionLimitsArray = JSONArray()

        val atmJsonObj = JSONObject()
        atmJsonObj.put(BaaSConstants.BS_KEY_CHANNEL, "ATM")
        atmJsonObj.put(BaaSConstants.BS_KEY_PER_TRANSACTION, 500000)
        atmJsonObj.put(BaaSConstants.BS_KEY_DAILY, 1500000)

        val posJsonObj = JSONObject()
        posJsonObj.put(BaaSConstants.BS_KEY_CHANNEL, "POS")
        posJsonObj.put(BaaSConstants.BS_KEY_PER_TRANSACTION, 500000)
        posJsonObj.put(BaaSConstants.BS_KEY_DAILY, 1500000)

        val ecomJsonObj = JSONObject()
        ecomJsonObj.put(BaaSConstants.BS_KEY_CHANNEL, "ECOM")
        ecomJsonObj.put(BaaSConstants.BS_KEY_PER_TRANSACTION, 500000)
        ecomJsonObj.put(BaaSConstants.BS_KEY_DAILY, 1500000)

        transactionLimitsArray.put(atmJsonObj)
        transactionLimitsArray.put(posJsonObj)
        transactionLimitsArray.put(ecomJsonObj)

        val apiParams = ApiParams().apply {
            transactionLimits = transactionLimitsArray
        }

        callAPI(ApiName.SET_LIMITS, apiParams)
    }

    fun set_transaction_mode(view: View) {
        val transactionModeJsonObj = JSONObject()

        transactionModeJsonObj.put(BaaSConstants.BS_KEY_ALLOW, true)
        transactionModeJsonObj.put(BaaSConstants.BS_KEY_CHANNEL, "ATM")
        transactionModeJsonObj.put(BaaSConstants.BS_KEY_LOCATION, "DOM")

        val apiParams = ApiParams().apply {
            transactionModes = transactionModeJsonObj
        }

        callAPI(ApiName.SET_TRANSACTION_MODE, apiParams)
    }

    fun createBeneficiary(view: View) {
        val apiParams = ApiParams().apply {
            beneficiaryName = "Tushar Patel"
            accountNumber = "123456789012"
            ifsc = "HDFC0004000"
        }
        callAPI(ApiName.ADD_BENEFICIARY, apiParams)
    }

    fun getBeneficiary(view: View) {
        val apiParams = ApiParams().apply {
            page = page
            size = size
            sort = sort
        }
        callAPI(ApiName.GET_BENEFICIARY, apiParams)
    }

    fun updateBeneficiary(view: View) {
        val apiParams = ApiParams().apply {
            beneficiaryId =
                SessionManager.getInstance(applicationContext).beneficiaryId
            beneficiaryName = "Tushar Gabani"
            accountNumber = "098765432109"
            ifsc = SessionManager.getInstance(applicationContext).beneficiaryIFSCECode
        }
        callAPI(ApiName.UPDATE_BENEFICIARY, apiParams)
    }

    fun doBeneficiaryBankTransfer(view: View) {
        val apiParams = ApiParams().apply {
            remarks = "Bank Transfer to my savings account"
            amount = 10
            beneficiaryId =
                SessionManager.getInstance(applicationContext).beneficiaryId
        }

        callAPI(ApiName.BENEFICIARY_BANK_TRANSFER, apiParams)
    }

    fun getRecentBeneficiary(view: View) {
        val apiParams = ApiParams().apply {
            page = page
            size = size
            sort = sort
        }
        callAPI(ApiName.GET_RECENT_BENEFICIARY, apiParams)
    }

    fun deleteBeneficiary(view: View) {
        val beneficiaryIds = JSONArray()
        beneficiaryIds.put(SessionManager.getInstance(applicationContext).beneficiaryId)


        val apiParams = ApiParams().apply {
            userBeneficiaryIds = beneficiaryIds
        }

        callAPI(ApiName.DELETE_BENEFICIARY, apiParams)
    }

    fun getSalaryAdvanceInfo(view: View) {
        val apiParams = ApiParams().apply {
        }
        callAPI(ApiName.GET_SALARY_ADVANCE_INFO, apiParams)
    }

    fun getAccountBalanceDetails(view: View) {
        val apiParams = ApiParams().apply {
        }
        callAPI(ApiName.GET_ACCOUNT_BALANCE_DETAILS, apiParams)
    }

    fun getTransactionDetail(view: View) {
        val apiParams = ApiParams().apply {
            accountType = "Saving" // will get from cardDetails api
            debitIndicator = "Debit"
            startDate = "2020-07-05"
            endDate = "2020-07-06"
        }
        callAPI(ApiName.GET_TRANSACTION_DETAILS, apiParams)
    }

    fun getAccountDetail(view: View) {
        val apiParams = ApiParams().apply {
        }
        callAPI(ApiName.GET_ACCOUNT_DETAILS, apiParams)
    }

    fun getUserDetails(view: View) {
        val apiParams = ApiParams().apply {
        }
        callAPI(ApiName.GET_USER_DETAILS, apiParams)
    }

    fun updateUserEmail(view: View) {
        val apiParams = ApiParams().apply {
            emailId = binding.etEmail.text.toString().trim()
        }

        callAPI(ApiName.UPDATE_USER_EMAIL, apiParams)
    }

    fun updateUserMobile(view: View) {
        val apiParams = ApiParams().apply {
            mobileNumber = binding.etMobile.text.toString().trim()
        }

        callAPI(ApiName.UPDATE_MOBILE_NUMBER, apiParams)
    }

    fun updateUserAddress(view: View) {

        val apiParams = ApiParams().apply {
            addressLine1 = binding.etAddress1.text.toString().trim()
            addressLine2 = binding.etAddress2.text.toString().trim()
            city = "Surat"
            pinCode = "394105"
            stateId = "Gujarat"
        }

        callAPI(ApiName.UPDATE_USER_ADDRESS, apiParams)
    }

    fun getTransactionCharges(view: View) {
        val apiParams = ApiParams().apply {
        }
        callAPI(ApiName.GET_TRANSACTION_CHARGES, apiParams)
    }

    fun addKYCResults(view: View) {
        val karzaVerificationString =
            com.payu.baas.core.storage.SessionManager.getInstance(this).karzaVerificationResponse
        if (!karzaVerificationString.isNullOrEmpty()) {
            val karzaVerificationResponse = JsonUtils.toObject(
                karzaVerificationString,
                KarzaVerificationResponse::class.java
            ) as KarzaVerificationResponse
            val apiParams = ApiParams().apply {
                panNumber = binding.etPancard.text.toString().trim()
                maskedAadhaar = karzaVerificationResponse.maskedAadhaar
                requestId = karzaVerificationResponse.requestId
                applicationId = karzaVerificationResponse.applicationId
                dob = karzaVerificationResponse.dobAadharXML!!.dob
                dob = dob!!.replace("/", "-")
                gender = karzaVerificationResponse.genderAadharXML!!.gender
                createTimeStamp = karzaVerificationResponse.createdTimeStamp
                panVerified = karzaVerificationResponse.panVerified
                livenessVerified = karzaVerificationResponse.livenessVerified
                xmlDateVerified = karzaVerificationResponse.xmlDateVerified
                isAadhaarVerified = karzaVerificationResponse.isAadhaarVerified
                var faceObject = JSONObject()
                faceObject.put("match", karzaVerificationResponse.faceAadhaarXML!!.matchScore)
                faceObject.put("matchMeta", karzaVerificationResponse.faceAadhaarXML!!.matchMeta)
                faceAadhaarXml = faceObject
                currentAddress = karzaVerificationResponse.currentAddress!!.address
                permanentAddress = karzaVerificationResponse.permanentAddress!!.address
                var userNameObject = JSONObject()
                userNameObject.put("match", karzaVerificationResponse.userNameDate!!.matchScore)
                userNameObject.put("matchMeta", karzaVerificationResponse.userNameDate!!.matchMeta)
                userNameObject.put("formData", karzaVerificationResponse.userNameDate!!.formData)
                userNameObject.put("panOCRData", karzaVerificationResponse.userNameDate!!.panOCRData)
                userNameObject.put(
                    "aadhaarXmlData",
                    karzaVerificationResponse.userNameDate!!.aadhaarXmlData
                )
                userNameData = userNameObject
            }
            callAPI(ApiName.KYC_RESULTS, apiParams)
        } else {
            showDialog("Karza verification is incomplete. Kindly generate karza results first.")
        }
    }

    fun verifyKYCResults(view: View) {
        val apiParams = ApiParams().apply {
        }
        callAPI(ApiName.VERIFY_KYC_RESULTS, apiParams)
    }

    fun validateKYCLocation(view: View) {
        val apiParams = ApiParams().apply {
            latitude = "28.704060"
            longitude = "77.102493"
            ipAddress = "192.1.1.1"
            state = "Punjab"
            country = "India"
        }
        callAPI(ApiName.KYC_LOCATION, apiParams)
    }

    fun validateKYCAadhar(view: View) {
        val apiParams = ApiParams().apply {
            xmlFileCode =
                com.payu.baas.core.storage.SessionManager.getInstance(this@MainActivity).karzaAadhaarFileCode
            xmlFileString =
                com.payu.baas.core.storage.SessionManager.getInstance(this@MainActivity).karzaAadhaarFileContent
        }
        callAPI(ApiName.KYC_AADHAR, apiParams)
    }

    @RequiresApi(Build.VERSION_CODES.R)
    fun validateKYCSelfie(view: View) {
        val apiParams = ApiParams().apply {
            live_photo =
                com.payu.baas.core.storage.SessionManager.getInstance(this@MainActivity).karzaUserSelfie
            karza_photo_name = "kyc_selfie_" + binding.etMobile.text.toString()+".jpg"
        }
        callAPI(ApiName.KYC_SELFIE, apiParams)
    }

    fun card_pin_status(view: View) {
        val apiParams = ApiParams()
        callAPI(ApiName.GET_PIN_STATUS, apiParams)
    }

    fun update_card_pin_status(view: View) {
        val apiParams = ApiParams().apply {
            pin_status = true
        }
        callAPI(ApiName.UPDATE_PIN, apiParams)
    }

    fun getApplicationId(view: View) {
        val apiParams = ApiParams().apply {
        }
        callAPI(ApiName.GET_APPLICATION_ID, apiParams)
    }

    fun generateKarzaToken(view: View) {
        val jsArray = JSONArray()
        jsArray.put("aadhaar_xml")
        jsArray.put("liveness")
        val apiParams = ApiParams().apply {
            productId = jsArray
        }
        callAPI(ApiName.KARZA_TOKEN, apiParams)
    }

    fun prevalidateTransaction(view: View) {
        val apiParams = ApiParams().apply {
            txnAmount = "100"
        }
        callAPI(ApiName.PREVALIDATE_TRANSACTION, apiParams)
    }

    private fun callAPI(apiName: ApiName, apiParams: ApiParams) {
        BaaSSDK.callApi(
            applicationContext,
            ApiDetails(apiName, apiParams),
            object : SdkCallback {
                override fun onSuccess(apiResponse: ApiResponse) {
                    when (apiName) {
                        ApiName.CARD_IMAGE -> {
                            binding.imageId.visibility = View.VISIBLE
                            var decodedStringImage: String =
                                Utils.decodeString(
                                    com.payu.baas.core.storage.SessionManager.getInstance(
                                        this@MainActivity
                                    ).cardImage!!
                                )
                            binding.tvApiResponse.text = decodedStringImage
                            Glide.with(applicationContext)
                                .load(decodedStringImage)
                                .error(R.drawable.ic_launcher_background)
                                .into(binding.imageId)
                        }
                        ApiName.ADD_BENEFICIARY -> {
                            var beneficiaryId =
                                SessionManager.getInstance(
                                    applicationContext
                                ).beneficiaryId
                            binding.etBeneficiaryId.text =
                                beneficiaryId!!.toEditable()
                            apiResponse.rawResponse?.let {
                                showDialog(it)
                            }
                        }
                        else -> {
                            binding.tvApiResponse.text = apiResponse.rawResponse
                            apiResponse.rawResponse?.let {
                                showDialog(it)
                            }
                        }
                    }

                    if (apiResponse is KarzaSessionResponse) {
                        var applicationId =
                            com.payu.baas.core.storage.SessionManager.getInstance(this@MainActivity).applicationId
                      //  applicationId = "85454"
                        if (!applicationId.isNullOrEmpty()) {
                            val objectId = JSONObject()
                            objectId.put(
                                "applicationId", applicationId
                            )
                            objectId.put("firstName", binding.etFirstName.text.toString().trim())
                            objectId.put("lastName", binding.etLastName.text.toString().trim())
                            val objectPan = JSONObject()
                            objectPan.put("panNo", binding.etPancard.text.toString().trim())
                            val apiParams = ApiParams().apply {
                                applicantFormData = objectId
                                panData = objectPan
                            }
                            callAPI(ApiName.KARZA_ADD_NEW_CUSTOMER, apiParams)
                        } else {
                            showDialog(BaaSConstants.APPLICATION_ID_EMPTY_ERROR_MESSAGE)
                        }
                    } else if (apiResponse is KarzaNewCustomerResponse) {
                        val apiParams = ApiParams().apply {
                            transactionId =
                                com.payu.baas.core.storage.SessionManager.getInstance(this@MainActivity).karzaTransactionId

                        }
                        callAPI(ApiName.KARZA_GENERATE_CUSTOMER_TOKEN, apiParams)
                    } else if (apiResponse is KarzaUserTokenResponse) {
                        var intent: Intent = Intent(this@MainActivity,
                            KarzaActivity::class.java)
                        startActivity(intent)
                    }
                }

                override fun onError(errorResponse: ErrorResponse) {
                    binding.tvApiResponse.text = errorResponse.errorMessage

                    errorResponse.errorMessage?.let { showDialog(it) }
                }

            })
    }

    private fun showDialog(message: String) {
        val builder = AlertDialog.Builder(this)
        builder.setMessage(message)
        builder.setPositiveButton("Ok") { _, _ ->
        }
        // Create the AlertDialog
        val alertDialog: AlertDialog = builder.create()
        // Set other dialog properties
        alertDialog.setCancelable(false)
        alertDialog.show()
    }

    fun serverCall(view: View) {
        val apiParams = ApiParams().apply {
        }
        callAPI(ApiName.SERVER_CALL, apiParams)
    }

}

fun String.toEditable(): Editable =
    Editable.Factory.getInstance().newEditable(this)