package com.example.activitylifecycle.sharedpref

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.activitylifecycle.R
import com.example.activitylifecycle.util.click

class SharedPrefActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_pref)
        val sharedPref = getSharedPreferences("MyPref", Context.MODE_PRIVATE)
        val edit = sharedPref.edit()
        val button: Button = findViewById(R.id.button)
        val editText: EditText = findViewById(R.id.editText)
        val textView: TextView = findViewById(R.id.textView)

        textView.text = sharedPref.getString("text", "No data")

        button.click {
            val text = editText.text.toString().trim()
            edit.putString("text", text)
            edit.apply()
            textView.text = text
        }
    }
}