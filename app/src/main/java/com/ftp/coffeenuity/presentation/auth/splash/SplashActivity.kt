package com.ftp.coffeenuity.presentation.auth.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.ftp.coffeenuity.R
import com.ftp.coffeenuity.data.pref.ProfilePrefs
import com.ftp.coffeenuity.presentation.MainActivity
import com.ftp.coffeenuity.presentation.auth.onboarding.OnBoardingActivity
import com.ftp.coffeenuity.utils.Constants.SPLASH_TIME_OUT

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler(Looper.getMainLooper()).postDelayed({
            when {
                ProfilePrefs.first_time -> {
                    startActivity(Intent(this, OnBoardingActivity::class.java))
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
                    finishAffinity()
                }
                ProfilePrefs.jwt_token.isNotEmpty() -> {
                    println(ProfilePrefs.jwt_token)
                    startActivity(Intent(this, MainActivity::class.java))
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
                    finishAffinity()
                }
                else -> {

                }
            }
        }, SPLASH_TIME_OUT)
    }
}