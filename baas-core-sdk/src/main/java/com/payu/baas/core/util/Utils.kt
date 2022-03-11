package com.payu.baas.core.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.util.Base64
import java.io.UnsupportedEncodingException
import java.util.*
import kotlin.collections.HashMap

object Utils {
    var isProduction: Boolean? = true
    var profileUpdate = HashMap<String, Any>()

    internal fun getAbsoluteUrl(relativeUrl: String) = "${BaaSConstants.BS_URL_PREFIX}$relativeUrl"
    var userStatusCodeString = ""
    internal fun init(context: Context, isProduction: Boolean? = true) {
        this.isProduction = isProduction
//        val dbId = PreferenceUtils.getInstance(context,BaaSConstants.PREFS_FILE_NAME).getString(BaaSConstants.BS_SP_DEVICE_BINDING_ID)
//        Session.getInstance(context).deviceBindingId = if (dbId.isNullOrEmpty()) UUID.randomUUID().toString() else dbId
    }

    fun decodeString(encoded: String): String {
        var decodedString = ""
        decodedString = try {
            val dataDec = Base64.decode(encoded, Base64.DEFAULT)
            String(dataDec, charset("UTF-8"))
        } catch (e: UnsupportedEncodingException) {
            e.printStackTrace()
            ""
        } finally {
            return decodedString
        }
    }

    fun identifyUsers() {
        profileUpdate["Name"] = "Ramesh Thimmana" // String
        profileUpdate["Identity"] = "Ramesh Thimmana" // String or number
        profileUpdate["Email"] = "advance_pay@gmail.com" // Email address of the user
        profileUpdate["Phone"] = "+91 7607881909" // Phone (with the country code, starting with +)
        profileUpdate["Gender"] = "Male" // Can be either M or F
        profileUpdate["DOB"] =
            Date() // Date of Birth. Set the Date object to the appropriate value first
// optional fields. controls whether the user will be sent email, push etc.
// optional fields. controls whether the user will be sent email, push etc.
        profileUpdate["MSG-email"] = false // Disable email notifications
        profileUpdate["MSG-push"] = true // Enable push notifications
        profileUpdate["MSG-sms"] = false // Disable SMS notifications
        profileUpdate["MSG-whatsapp"] = true // Enable WhatsApp notifications

    }

    fun isInternetAvailable(context: Context): Boolean {

        // register activity with the connectivity manager service
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        // if the android version is equal to M
        // or greater we need to use the
        // NetworkCapabilities to check what type of
        // network has the internet connection
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            // Returns a Network object corresponding to
            // the currently active default data network.
            val network = connectivityManager.activeNetwork ?: return false

            // Representation of the capabilities of an active network.
            val activeNetwork = connectivityManager.getNetworkCapabilities(network) ?: return false

            return when {
                // Indicates this network uses a Wi-Fi transport,
                // or WiFi has network connectivity
                activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true

                // Indicates this network uses a Cellular transport. or
                // Cellular has network connectivity
                activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true

                // else return false
                else -> false
            }
        } else {
            // if the android version is below M
            @Suppress("DEPRECATION") val networkInfo =
                connectivityManager.activeNetworkInfo ?: return false
            @Suppress("DEPRECATION")
            return networkInfo.isConnected
        }
    }
}