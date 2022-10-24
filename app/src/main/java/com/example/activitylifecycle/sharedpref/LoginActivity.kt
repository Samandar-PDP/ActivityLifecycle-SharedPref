package com.example.activitylifecycle.sharedpref

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ProgressBar
import android.widget.Toast
import androidx.core.text.isDigitsOnly
import androidx.core.view.isVisible
import com.example.activitylifecycle.R
import com.example.activitylifecycle.sharedpref.model.User
import com.example.activitylifecycle.sharedpref.user_shared.UserSharedPref
import com.example.activitylifecycle.util.click
import com.example.activitylifecycle.util.start
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class LoginActivity : AppCompatActivity() {
    private lateinit var editName: TextInputEditText
    private lateinit var editLast: TextInputEditText
    private lateinit var editAge: TextInputEditText
    private lateinit var button: MaterialButton
    private lateinit var progressBar: ProgressBar
    private val sharedPref by lazy { UserSharedPref(this) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        editName = findViewById(R.id.name)
        editLast = findViewById(R.id.lastname)
        editAge = findViewById(R.id.age)
        button = findViewById(R.id.button)
        progressBar = findViewById(R.id.progressBar)

        button.setOnClickListener {
            val name = editName.text.toString().trim()
            val lastName = editLast.text.toString().trim()
            val age = editAge.text.toString().trim()
            progressBar.isVisible = true
            Handler(Looper.getMainLooper()).postDelayed({
                if (editTextValidate(name, lastName, age)) {
                    progressBar.isVisible = false
                    sharedPref.saveUser(User(name, lastName, age.toInt()))
                    startActivity(Intent(this, HomeActivity::class.java))
                    finish()
                } else {
                    progressBar.isVisible = false
                    Toast.makeText(this, "Enter data correctly!", Toast.LENGTH_SHORT).show()
                }
            }, 2000)
        }
    }

    private fun editTextValidate(name: String, lastName: String, age: String): Boolean {
        editName.error = null
        editLast.error = null
        editAge.error = null
        if (name.isEmpty()) {
            editName.error = "Enter name!"
            return false
        }
        if (lastName.isEmpty()) {
            editLast.error = "Enter lastname!"
            return false
        }
        if (age.isDigitsOnly()) {
            if (age.toInt() <= 0 || age.isEmpty()) {
                editAge.error = "Enter age!"
                return false
            }
        }
        return true
    }
}