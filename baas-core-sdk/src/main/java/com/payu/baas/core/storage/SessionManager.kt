package com.payu.baas.core.storage

import android.annotation.SuppressLint
import android.content.Context
import com.payu.baas.core.model.responseModels.KarzaVerificationResponse
import com.payu.baas.core.util.BaaSConstants
import com.payu.baas.core.util.BaaSConstants.PREFS_FILE_NAME
import com.payu.baas.core.util.BaasEncryption
import java.util.*

class SessionManager private constructor(val context: Context) {


    companion object {
        @SuppressLint("StaticFieldLeak")
        @Volatile
        private var instance: SessionManager? = null
        fun getInstance(context: Context): SessionManager {
            val checkInstance = instance
            if (checkInstance != null) {
                return checkInstance
            }

            return synchronized(this) {
                val checkInstanceAgain = instance
                if (checkInstanceAgain != null) {
                    checkInstanceAgain
                } else {
                    val created = SessionManager(context)
                    instance = created

                    // assign constants
                    created.deviceBindingId = UUID.randomUUID().toString()
                    created.brandToken = BaaSConstants.BS_VALUE_BRAND_TOKEN

                    created

                }
            }
        }
    }

    var accessToken: String? = null
        get() = if (field.isNullOrEmpty())
            null
        else
            BaasEncryption.decrypt(field)
        set(value) {
            field = BaasEncryption.encrypt(value!!)
            PreferenceUtils.getInstance(context, PREFS_FILE_NAME)
                .putString(BaaSConstants.BS_SP_ACCESS_TOKEN, field)
        }

    var deviceBindingId: String? = null
        get() = if (field.isNullOrEmpty())
            null
        else
            BaasEncryption.decrypt(field)
        set(value) {
            field = BaasEncryption.encrypt(value!!)
            PreferenceUtils.getInstance(context, PREFS_FILE_NAME)
                .putString(BaaSConstants.BS_SP_DEVICE_BINDING_ID, field)
        }

    var brandToken: String? = null
        get() = if (field.isNullOrEmpty())
            null
        else
            BaasEncryption.decrypt(field)
        set(value) {
            field = BaasEncryption.encrypt(value!!)
            PreferenceUtils.getInstance(context, PREFS_FILE_NAME)
                .putString(BaaSConstants.BS_SP_BRAND_TOKEN, field)
        }

    var cardImage: String? = null
        get() = if (field.isNullOrEmpty())
            null
        else
            BaasEncryption.decrypt(field)
        set(value) {
            field = BaasEncryption.encrypt(value!!)
            PreferenceUtils.getInstance(context, PREFS_FILE_NAME)
                .putString(BaaSConstants.BS_SP_CARD_IMAGE, field)
        }
    var applicationId: String? = null
        set(value) {
            field = value
            PreferenceUtils.getInstance(context, PREFS_FILE_NAME)
                .putString(BaaSConstants.BS_SP_APPLICATION_ID, value)
        }
    var karzaToken: String? = null
        set(value) {
            field = value
            PreferenceUtils.getInstance(context, PREFS_FILE_NAME)
                .putString(BaaSConstants.BS_SP_KARZA_TOKEN, value)
        }
    var karzaTransactionId: String? = null
        set(value) {
            field = value
            PreferenceUtils.getInstance(context, PREFS_FILE_NAME)
                .putString(BaaSConstants.BS_SP_KARZA_TRANSACTION_ID, value)
        }
    var karzaUserToken: String? = null
        set(value) {
            field = value
            PreferenceUtils.getInstance(context, PREFS_FILE_NAME)
                .putString(BaaSConstants.BS_SP_KARZA_USER_TOKEN, value)
        }
    var karzaUserSelfie: String? = null
        set(value) {
            field = value
            PreferenceUtils.getInstance(context, PREFS_FILE_NAME)
                .putString(BaaSConstants.BS_SP_KARZA_USER_SELFIE, value)
        }

    var karzaAadhaarFileContent: String? = null
        set(value) {
            field = value
            PreferenceUtils.getInstance(context, PREFS_FILE_NAME)
                .putString(BaaSConstants.BS_SP_KARZA_AADHAAR_CONTENT, value)
        }
    var karzaAadhaarFileCode: String? = null
        set(value) {
            field = value
            PreferenceUtils.getInstance(context, PREFS_FILE_NAME)
                .putString(BaaSConstants.BS_SP_KARZA_AADHAAR_CODE, value)
        }

    var karzaVerificationResponse: String? = null
        set(value) {
            field = value
            PreferenceUtils.getInstance(context, PREFS_FILE_NAME)
                .putString(BaaSConstants.BS_SP_KARZA_AADHAR_RESPONSE, value)
        }
    var userStatusCode: String? = null
        set(value) {
            field = value
            PreferenceUtils.getInstance(context, PREFS_FILE_NAME)
                .putString(BaaSConstants.BS_SP_USER_STATE, value)
        }
    var beneficiaryId: String? = null
        set(value) {
            field = value
            PreferenceUtils.getInstance(context, PREFS_FILE_NAME)
                .putString(BaaSConstants.BS_SP_USER_BENIFICIARY_ID, value)
        }
    var beneficiaryIFSCECode: String? = null
        set(value) {
            field = value
            PreferenceUtils.getInstance(context, PREFS_FILE_NAME)
                .putString(BaaSConstants.BS_SP_USER_BENIFICIARY_ID, value)
        }
//    var mockServerBaseUrl: String? = null
//        set(value) {
//            field = value
//            PreferenceUtils.getInstance(context, PREFS_FILE_NAME)
//                .putString(BaaSConstants.BS_SP_ACCESS_TOKEN, value)
//        }
}