package com.payu.baas.core.util

object BaaSConstants {
    const val BS_URL_PREFIX = "https://baas.payu.in/baas/v1/"
    const val BS_VALUE_BRAND_TOKEN = "wjxpbsldcxxwxvav"

    const val BS_URL_INITIAL_SERVER_CALL = "https://baasdevtest.payu.in/baas/"
    const val PREFS_FILE_NAME: String = "baasSdkFile"
    const val BS_SP_BRAND_TOKEN = "brand_token"
    
    const val BS_SP_ACCESS_TOKEN = "access_token"
    const val BS_SP_DEVICE_BINDING_ID = "dbid"
    const val BS_SP_CARD_IMAGE = "card_image"
    const val BS_SP_S3_BUCKET_URL = "s3BucketUrl"


    // API values
    const val BS_VALUE_TYPE = "SignIn"
    const val BS_SP_ZD_URL = "zdUrl"
    const val BS_SP_ZD_APP_ID = "zdAppId"
    const val BS_SP_ZD_CLIENT_ID = "zdClientId"
    const val BS_SP_KARZA_TOKEN = "karza_token"
    const val BS_SP_KARZA_USER_TOKEN = "karza_user_token"
    const val BS_SP_KARZA_USER_SELFIE = "karza_user_selfie"
    const val BS_SP_KARZA_AADHAR_RESPONSE = "karza_aadhar_response"
    const val BS_SP_KARZA_AADHAAR_CONTENT = "karza_aadhaar_content"
    const val BS_SP_KARZA_AADHAAR_CODE = "karza_aadhaar_code"
    const val BS_SP_KARZA_TRANSACTION_ID = "karza_transaction_id"
    const val BS_SP_KARZA_KEY = "karza_key"
    const val BS_SP_APPLICATION_ID = "application_id"
    const val BS_SP_USER_STATE = "user_state"
    const val BS_SP_USER_BENIFICIARY_ID = "user_benificiary_id"
    const val BS_SP_USER_BENIFICIARY_IFSC = "user_benificiary_ifsc"
    const val BS_SP_OTP_LENGTH = 4

    // API Keys
    const val BS_KEY_BRAND_TOKEN = "brandToken"
    const val BS_KEY_DEVICE_BINDING_ID = "deviceBindingId"
    const val BS_KEY_ACCESS_TOKEN = "accessToken"
    const val BS_KEY_KARZA_TOKEN = "karzatoken"
    const val BS_KEY_CONTENT_TYPE = "Content-Type"
    const val BS_KEY_MOBILE = "mobile"
    const val BS_KEY_TYPE = "type"
    const val BS_KEY_CODE = "code"
    const val BS_KEY_IDENTITY = "identity"
    const val BS_KEY_USERNAME = "username"
    const val BS_KEY_PASSWORD = "password"
    const val BS_KEY_PAN_NUMBER = "panNumber"
    const val BS_KEY_MOBILE_NUMBER = "mobile"
    const val BS_KEY_MOBILE_NUMBER_FOR_USER_STATE = "mobileNumber"
    const val BS_KEY_PIN_STATUS = "pin_status"
    const val BS_KEY_OLD_PASSWORD = "oldPasscode"
    const val BS_KEY_NEW_PASSWORD = "newPasscode"
    const val BS_KEY_PAN = "pan"
    const val BS_KEY_ID = "id"
    const val BS_KEY_BRAND_EMP_ID = "brandEmpId"
    const val BS_KEY_ACCOUNT_TYPE = "accountType"
    const val BS_KEY_DEBIT_INDICATOR = "debitIndicator"
    const val BS_KEY_START_DATE = "startDate"
    const val BS_KEY_END_DATE = "endDate"
    const val BS_KEY_TITLE = "title"
    const val BS_KEY_FIRST_NAME = "firstName"
    const val BS_KEY_LAST_NAME = "lastName"
    const val BS_KEY_GENDER = "gender"
    const val BS_KEY_DOB = "dob"
    const val BS_KEY_EMAIL = "email"
    const val BS_KEY_COUNTRY = "country"
    const val BS_KEY_COUNTRY_CODE = "countryCode"
    const val BS_KEY_ADDRESS_LINE_1 = "addressLine1"
    const val BS_KEY_ADDRESS_LINE_2 = "addressLine2"
    const val BS_KEY_CITY = "city"
    const val BS_KEY_PIN_CODE = "pinCode"
    const val BS_KEY_STATE = "state"
    const val BS_KEY_STATE_ID = "stateId"
    const val BS_KEY_EMPLOYEE_ID = "employeeId"
    const val BS_KEY_BENEFICIARY_NAME = "beneficiaryName"
    const val BS_KEY_ACCOUNT_NUMBER = "accountNumber"
    const val BS_KEY_IFSC = "ifsc"
    const val BS_KEY_BENEFICIARY_ID = "beneficiaryId"
    const val BS_KEY_USER_BENEFICIARY_IDS = "userBeneFiciaryIds"
    const val BS_KEY_EMAIL_ID = "emailId"
    const val BS_KEY_REMARKS = "remarks"
    const val BS_KEY_USER_BANK_TRANSFER_BENEFICIARY_ID = "beneficiary_id"
    const val BS_KEY_AMOUNT = "amount"
    const val BS_KEY_REASON = "reason"
    const val BS_KEY_REDIRECT_LINK = "redirect_link"
    const val BS_KEY_ALLOW = "allow"
    const val BS_KEY_CHANNEL = "channel"
    const val BS_KEY_LOCATION = "location"
    const val BS_KEY_PER_TRANSACTION = "perTransaction"
    const val BS_KEY_DAILY = "daily"
    const val BS_KEY_TRANSACTION_MODES = "transactionMode"
    const val BS_KEY_LIVE_PHOTO = "live_photo"
    const val BS_KEY_KARZA_SELFIE_NAME = "karza_selfie_name"
    const val BS_KEY_XML = "xmlFileString"
    const val BS_KEY_XML_FILE_CODE = "shareCode"
    const val BS_KEY_MASKED_AADHAAR = "maskedAadhaar"
    const val BS_KEY_REQUEST_ID = "requestId"
    const val BS_KEY_APPLICATION_ID = "applicationId"
    const val BS_KEY_PAN_VERIFIED = "panVerified"
    const val BS_KEY_AADHAAR_VERIFIED = "isAadhaarVerified"
    const val BS_KEY_XML_DATE_VERIFIED = "xmlDateVerified"
    const val BS_KEY_LIVENESS_VERIFIED = "livenessVerified"
    const val BS_KEY_CREATED_TIME_STAMP = "createTimeStamp"
    const val BS_KEY_FACE_AADHAAR_XML = "faceAadhaarXml"
    const val BS_KEY_CURRENT_ADDRESS = "currentAddress"
    const val BS_KEY_PERMANENT_ADDRESS = "permanentAddress"
    const val BS_KEY_USER_NAME_DATA = "userNameData"
    const val BS_KEY_PRODUCT_ID = "productId"
    const val BS_KEY_LATITUDE = "latitude"
    const val BS_KEY_LONGITUDE = "longitude"
    const val BS_KEY_IP_ADDRESS = "ipAddress"
    const val BS_KEY_PAGE = "page"
    const val BS_KEY_SIZE = "size"
    const val BS_KEY_SORT = "sort"
    const val BS_KEY_KARZA_TRANSACTION_ID = "transactionId"
    const val BS_KEY_KARZA_APPLICATION_FORM_DATA = "applicantFormData"
    const val BS_KEY_KARZA_PAN_DATA = "panData"

    const val BS_KEY_TRANSACTION_LIMITS = "transactionLimits"
    const val BS_KEY_TRANSACTION_AMOUNT = "txnAmount"

    const val BS_KEY_IS_CARD_RECEIVED = "isCardReceived"

    // error codes
    const val INVALID_DATA = "Invalid data"
    const val NO_INTERNET_ERROR_CODE = 1000
    const val MOBILE_EMPTY_ERROR_CODE = 1001
    const val OTP_EMPTY_ERROR_CODE = 1002
    const val USERNAME_EMPTY_ERROR_CODE = 1003
    const val PASSWORD_EMPTY_ERROR_CODE = 1004
    const val PAN_NUMBER_EMPTY_ERROR_CODE = 1005
    const val EMPLOYEE_ID_EMPTY_ERROR_CODE = 1006
    const val NEW_PASSWORD_EMPTY_ERROR_CODE = 1008
    const val TITLE_EMPTY_ERROR_CODE = 1009
    const val FIRST_NAME_EMPTY_ERROR_CODE = 1010
    const val LAST_NAME_EMPTY_ERROR_CODE = 1011
    const val GENDER_EMPTY_ERROR_CODE = 1012
    const val DOB_EMPTY_ERROR_CODE = 1013
    const val EMAIL_EMPTY_ERROR_CODE = 1014
    const val COUNTRY_EMPTY_ERROR_CODE = 1015
    const val COUNTRY_CODE_EMPTY_ERROR_CODE = 1016
    const val ADDRESS_1_CODE_EMPTY_ERROR_CODE = 1017
    const val ADDRESS_2_CODE_EMPTY_ERROR_CODE = 1018
    const val CITY_EMPTY_ERROR_CODE = 1019
    const val PIN_CODE_EMPTY_ERROR_CODE = 1020
    const val STATE_EMPTY_ERROR_CODE = 1021
    const val BENEFICIARY_NAME_EMPTY_ERROR_CODE = 1022
    const val BENEFICIARY_ACCOUNT_NUMBER_EMPTY_ERROR_CODE = 1023
    const val BENEFICIARY_IFSC_EMPTY_ERROR_CODE = 1024
    const val BENEFICIARY_ID_EMPTY_ERROR_CODE = 1025
    const val AMOUNT_EMPTY_ERROR_CODE = 1030
    const val ADDRESS_EMPTY_ERROR_CODE = 1035
    const val REDIRECT_LINK_EMPTY_ERROR_CODE = 2001
    const val REASON_EMPTY_ERROR_CODE = 2002
    const val TRANSACTION_MODE_EMPTY_ERROR_CODE = 2003
    const val TRANSACTION_AMOUNT_EMPTY_ERROR_CODE = 2004
    const val TRANSACTION_LIMIT_EMPTY_ERROR_CODE = 2009
    const val PHOTO_EMPTY_ERROR_CODE = 2010
    const val AADHAR_EMPTY_ERROR_CODE = 2011
    const val APPLICATION_ID_EMPTY_ERROR_CODE = 2014
    const val TRANSACTION_ID_ERROR_CODE = 2015

    // error messages
    const val NO_INTERNET_ERROR_MESSAGE = "No internet available"
    const val TRANSACTION_LIMIT_EMPTY_ERROR_MESSAGE = "Transaction Limit shouldn't be null or empty"
    const val MOBILE_EMPTY_ERROR_MESSAGE = "Mobile shouldn't be null or empty"
    const val OTP_EMPTY_ERROR_MESSAGE = "OTP shouldn't be null or empty"
    const val USERNAME_EMPTY_ERROR_MESSAGE = "Username shouldn't be null or empty"
    const val PASSWORD_EMPTY_ERROR_MESSAGE = "Password shouldn't be null or empty"
    const val PAN_NUMBER_EMPTY_ERROR_MESSAGE = "Pan number shouldn't be null or empty"
    const val EMPLOYEE_ID_EMPTY_ERROR_MESSAGE = "Employee id shouldn't be null or empty"
    const val NEW_PASSWORD_EMPTY_ERROR_MESSAGE = "New password shouldn't be null or empty"
    const val TITLE_EMPTY_ERROR_MESSAGE = "Title shouldn't be null or empty"
    const val FIRST_NAME_EMPTY_ERROR_MESSAGE = "First name shouldn't be null or empty"
    const val LAST_NAME_EMPTY_ERROR_MESSAGE = "Last name shouldn't be null or empty"
    const val GENDER_EMPTY_ERROR_MESSAGE = "Gender shouldn't be null or empty"
    const val DOB_EMPTY_ERROR_MESSAGE = "Date of birth shouldn't be null or empty"
    const val EMAIL_EMPTY_ERROR_MESSAGE = "Email shouldn't be null or empty"
    const val COUNTRY_EMPTY_ERROR_MESSAGE = "Country shouldn't be null or empty"
    const val COUNTRY_CODE_EMPTY_ERROR_MESSAGE = "Country code shouldn't be null or empty"
    const val ADDRESS_1_EMPTY_ERROR_MESSAGE = "Address 1 shouldn't be null or empty"
    const val ADDRESS_2_EMPTY_ERROR_MESSAGE = "Address 2 shouldn't be null or empty"
    const val CITY_EMPTY_ERROR_MESSAGE = "City shouldn't be null or empty"
    const val PIN_CODE_EMPTY_ERROR_MESSAGE = "Pin code shouldn't be null or empty"
    const val STATE_EMPTY_ERROR_MESSAGE = "State shouldn't be null or empty"
    const val BENEFICIARY_NAME_EMPTY_ERROR_MESSAGE = "Beneficiary name shouldn't be null or empty"
    const val BENEFICIARY_ACCOUNT_NUMBER_EMPTY_ERROR_MESSAGE =
        "Beneficiary account number shouldn't be null or empty"
    const val BENEFICIARY_IFSC_EMPTY_ERROR_MESSAGE = "Beneficiary IFSC shouldn't be null or empty"
    const val BENEFICIARY_ID_EMPTY_ERROR_MESSAGE = "Beneficiary Id shouldn't be null or empty"
    const val AMOUNT_EMPTY_ERROR_MESSAGE = "Amount shouldn't zero"
    const val TRANSACTION_AMOUNT_EMPTY_ERROR_MESSAGE = "Transaction amount shouldn't be null or empty"
    const val ADDRESS_EMPTY_ERROR_MESSAGE = "We are fetching your location. Kindly wait for a while."
    const val REDIRECT_LINK_EMPTY_ERROR_MESSAGE = "Redirect link shouldn't be null or empty"
    const val REASON_EMPTY_ERROR_MESSAGE = "Reason shouldn't be null or empty"
    const val TRANSACTION_MODE_EMPTY_ERROR_MESSAGE = "Transaction mode shouldn't be null or empty"
    const val PHOTO_EMPTY_ERROR_MESSAGE = "Photo shouldn't be null or empty"
    const val AADHAR_EMPTY_ERROR_MESSAGE = "Aadhar shouldn't be null or empty"
    const val AADHAR_FILE_CODE_EMPTY_ERROR_MESSAGE = "Aadhar file code is missing."
    const val MASKED_AADHAR_EMPTY_ERROR_MESSAGE = "Masked Aadhar shouldn't be null or empty"
    const val PERMANENT_ADDRESS_EMPTY_ERROR_MESSAGE = "Permanent Address shouldn't be null or empty"
    const val CURRENT_ADDRESS_EMPTY_ERROR_MESSAGE = "Current Address shouldn't be null or empty"
    const val TIME_STAMP_EMPTY_ERROR_MESSAGE = "Time stamp shouldn't be null or empty"
    const val REQUEST_ID_EMPTY_ERROR_MESSAGE = "Request id shouldn't be null or empty"
    const val USER_DATA_AADHAR_EMPTY_ERROR_MESSAGE = "User data shouldn't be null or empty"
    const val FACE_AADHAR_EMPTY_ERROR_MESSAGE = "Face data shouldn't be null or empty"
    const val APPLICATION_ID_EMPTY_ERROR_MESSAGE = "Application id is null. Kindly generate it first."
    const val SOMETHING_WENT_WRONG_ERROR_MESSAGE = "Something went wrong, could not complete the request now. Please try again later!"
    const val TRANSACTION_ID_EMPTY_ERROR_MESSAGE = "Transaction id shouldn't be null or empty"
}