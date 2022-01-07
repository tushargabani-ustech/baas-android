package com.payu.baasSampleApp

import android.telephony.PhoneNumberUtils
import android.view.View
import android.widget.EditText
import com.payu.baas.core.model.apiModels.GetAccountBalanceApiModel
import com.payu.baas.core.model.model.*
import com.payu.baas.core.model.responseModels.ApiResponse
import com.payu.baas.core.model.responseModels.SaveAddressResponse
import com.payu.baas.core.model.responseModels.VerifyOtpResponse
import com.payu.baas.core.util.BaaSConstants
import com.payu.baas.core.util.JsonUtils
import junit.framework.TestCase
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import java.io.IOException
import java.lang.Exception
import okhttp3.mockwebserver.RecordedRequest
import retrofit2.Call
import java.util.concurrent.TimeUnit


@RunWith(RobolectricTestRunner::class)
class HomeScreenUnitTests {
    var mockApiCaller: MockApiCallManger? = null

    @Before
    fun setUp() {
        mockApiCaller = MockApiCallManger()
        mockApiCaller!!.initialize()
    }

    /* Bellow all tests will be tested
    With  service created we can now call its method that should
   consume the MockResponse above.
   assertion to check if the result is as expected.
        */
    @Test
    @Throws(IOException::class)
    fun testForGetAccountBalanceDetailsApi() {
        TestCase.assertNull(
            mockApiCaller!!.callForGetAccountBalanceDetailsApi().execute()
                .body()!!.error
        )
        // test for correct request passed
        val recordedRequest: RecordedRequest? =
            mockApiCaller!!.mockWebServer.takeRequest(1, TimeUnit.SECONDS)
        TestCase.assertEquals("GET", recordedRequest!!.method)
    }
    @Test
    @Throws(IOException::class)
    fun testForGetAccountTransactionDetailsApi() {
        TestCase.assertNull(
            mockApiCaller!!.callForGetTransactionDetailsApi().execute()
                .body()!!.error
        )
        // test for correct request passed
        val recordedRequest: RecordedRequest? =
            mockApiCaller!!.mockWebServer.takeRequest(1, TimeUnit.SECONDS)
        TestCase.assertEquals("GET", recordedRequest!!.method)
    }
    @Test
    @Throws(IOException::class)
    fun testForGetAccountDetailsApi() {
        TestCase.assertNull(
            mockApiCaller!!.callForGetAccountDetailsApi().execute()
                .body()!!.error
        )
        // test for correct request passed
        val recordedRequest: RecordedRequest? =
            mockApiCaller!!.mockWebServer.takeRequest(1, TimeUnit.SECONDS)
        TestCase.assertEquals("GET", recordedRequest!!.method)
    }
    @Test
    @Throws(IOException::class)
    fun testForGetUserDetailsApi() {
        TestCase.assertNull(
            mockApiCaller!!.callForGetUserDetailsApi().execute()
                .body()
        )
        // test for correct request passed
        val recordedRequest: RecordedRequest? =
            mockApiCaller!!.mockWebServer.takeRequest(1, TimeUnit.SECONDS)
        TestCase.assertEquals("GET", recordedRequest!!.method)
    }
    @Test
    @Throws(IOException::class)
    fun testForUpdateEmailApi() {
        TestCase.assertNull(
            mockApiCaller!!.callForUpdateUserEmailApi().execute()
                .body()
        )

        val recordedRequest: RecordedRequest? =
            mockApiCaller!!.mockWebServer.takeRequest(1, TimeUnit.SECONDS)
        // test for correct request method
        TestCase.assertEquals("POST", recordedRequest!!.method)
    }
    @Test
    @Throws(IOException::class)
    fun testForUpdateAddressApi() {
        TestCase.assertNull(
            mockApiCaller!!.callForUpdateUserAddressApi().execute()
                .body()
        )

        val recordedRequest: RecordedRequest? =
            mockApiCaller!!.mockWebServer.takeRequest(1, TimeUnit.SECONDS)
        // test for correct request method
        TestCase.assertEquals("POST", recordedRequest!!.method)
    }
    @Test
    @Throws(IOException::class)
    fun testForUpdateMobileNumberApi() {
        TestCase.assertNull(
            mockApiCaller!!.callForUpdateUserMobileNumberApi().execute()
                .body()
        )

        val recordedRequest: RecordedRequest? =
            mockApiCaller!!.mockWebServer.takeRequest(1, TimeUnit.SECONDS)
        // test for correct request method
        TestCase.assertEquals("POST", recordedRequest!!.method)
    }
    @After
    fun shutDown() {
        mockApiCaller!!.tearDownServer()
    }
}