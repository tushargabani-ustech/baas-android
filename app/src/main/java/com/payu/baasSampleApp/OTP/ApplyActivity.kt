package com.payu.baasSampleApp.OTP

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.payu.baasSampleApp.R
import com.payu.baasSampleApp.databinding.ActivityMainBinding

class ApplyActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        super.setContentView( R.layout.activity_apply)
            binding = DataBindingUtil.setContentView(this, R.layout.activity_apply)
    }
}