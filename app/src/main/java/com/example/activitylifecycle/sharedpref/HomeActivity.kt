package com.example.activitylifecycle.sharedpref

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.activitylifecycle.R
import com.example.activitylifecycle.sharedpref.user_shared.UserSharedPref

class HomeActivity : AppCompatActivity() {
    private lateinit var textView: TextView
    private lateinit var button: Button
    private val sharedPref by lazy { UserSharedPref(this) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        textView = findViewById(R.id.textView)
        button = findViewById(R.id.button)

        val user = sharedPref.getUser()
        user?.let {
            textView.text = "${it.name}\n${it.lastName}\n${it.age}"
        }
        button.setOnClickListener {
            sharedPref.clearUser()
            finish()
        }
    }
}