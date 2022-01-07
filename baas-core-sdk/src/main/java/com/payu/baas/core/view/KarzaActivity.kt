package com.payu.baas.core.view

import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.karza.okycmaster.ActionType
import com.karza.okycmaster.KDataListener
import com.karza.okycmaster.KManager
import com.karza.okycmaster.SDKEnv
import com.payu.baas.core.R
import com.payu.baas.core.model.responseModels.KarzaAadharResponse
import com.payu.baas.core.model.responseModels.KarzaSelfieResponse
import com.payu.baas.core.storage.SessionManager
import com.payu.baas.core.util.BaaSConstants
import com.payu.baas.core.util.JsonUtils
import org.json.JSONObject

class KarzaActivity : AppCompatActivity(), KDataListener {
    lateinit var kManager: KManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_karza_sdkactivity)
        kManager = KManager.Builder(supportFragmentManager)
            .setContext(applicationContext)
            .setUserToken(SessionManager.getInstance(this).karzaUserToken)
            .setDataListener(this)
            .setEnv(SDKEnv.TEST)
            .build()
        kManager.init(R.id.frameLayout);
    }

    override fun onStarted() {

    }

    override fun onExit() {
    }
    override fun permissionMissing(permissions: Array<out String>?) {
        ActivityCompat.requestPermissions(this, permissions!!, 204)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String?>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (grantResults[0].equals(PackageManager.PERMISSION_GRANTED)) {
            kManager = KManager.Builder(supportFragmentManager)
                .setContext(applicationContext)
                .setUserToken(SessionManager.getInstance(this).karzaUserToken)
                .setDataListener(this)
                .setEnv(SDKEnv.TEST)
                .build()
            kManager.init(R.id.frameLayout);
        }
    }

    override fun onEvent(
        httpStatus: Int, apiStatus: Int, docType: String?,
        actionType: ActionType?, data: JSONObject?
    ) {
        val builder = if ("HttpStatus : " + httpStatus + " , " +
            "apiStatus : " + apiStatus + " , " +
            "docType : " + docType + " , " +
            "ActionType : " + actionType!!.type + " , " +
            "data : " + data != null
        ) data.toString() else "data is null"
        Log.i(BaaSConstants.LOG_TAG, "onEvent : $builder")
        if (docType.equals("from_aadhaar_xml")) {
            var response: KarzaAadharResponse =
                JsonUtils.toObject(builder, KarzaAadharResponse::class.java) as KarzaAadharResponse
            SessionManager.getInstance(this).karzaAadhaarFileContent = response.zipFileBase64
            SessionManager.getInstance(this).karzaAadhaarFileCode = response.sharecode
        } else if (docType.equals("silent_liveness")) {
            var response: KarzaSelfieResponse =
                JsonUtils.toObject(builder, KarzaSelfieResponse::class.java) as KarzaSelfieResponse
            SessionManager.getInstance(this).karzaUserSelfie =
                response.image?.get(0)
        } else if (docType.equals("from_pan")) {

        } else if (actionType == ActionType.REPORT_DATA)
            SessionManager.getInstance(this).karzaVerificationResponse = builder
        else if (actionType == ActionType.END) { //docType contains value for which we working on like it will be liveness if working on selfie,
            SessionManager.getInstance(this).karzaTransactionId = null
            finish()
        }
        //adhar_xml for adhar verification
    }

}