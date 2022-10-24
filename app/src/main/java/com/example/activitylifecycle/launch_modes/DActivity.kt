package com.example.activitylifecycle.launch_modes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.activitylifecycle.R
import com.example.activitylifecycle.util.click
import com.example.activitylifecycle.util.start

class DActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dactivity)

        supportActionBar?.title = "D"

        val button: Button = findViewById(R.id.button)
        button.click {
            start(BActivity())
        }
    }
}