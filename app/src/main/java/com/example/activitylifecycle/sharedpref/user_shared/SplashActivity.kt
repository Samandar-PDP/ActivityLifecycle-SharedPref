package com.example.activitylifecycle.sharedpref.user_shared

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.example.activitylifecycle.R
import com.example.activitylifecycle.sharedpref.HomeActivity
import com.example.activitylifecycle.sharedpref.LoginActivity

class SplashActivity : AppCompatActivity() {
    private val sharedPref by lazy { UserSharedPref(this) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        object : CountDownTimer(2000, 1000) {
            override fun onTick(p0: Long) {}

            override fun onFinish() {
                if (sharedPref.getUser() == null) {
                    startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
                    finish()
                } else {
                    startActivity(Intent(this@SplashActivity, HomeActivity::class.java))
                    finish()
                }
            }
        }.start()
    }
}