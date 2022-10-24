package com.example.activitylifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        toast("OnCreate2 ishga tushdi")
        log("OnCreate2 ishga tushdi")
    }

    override fun onStart() {
        super.onStart()
        toast("onStart2 ishga tushdi")
        log("onStart2 ishga tushdi")
    }

    override fun onResume() {
        super.onResume()
        toast("onResume2 ishga tushdi")
        log("onResume2 ishga tushdi")
    }

    override fun onPause() {
        super.onPause()
        toast("onPause2 ishga tushdi")
        log("onPause2 ishga tushdi")
    }

    override fun onStop() {
        super.onStop()
        toast("onStop2 ishga tushdi")
        log("onStop2 ishga tushdi")
    }

    override fun onDestroy() {
        super.onDestroy()
        toast("onDestroy2 ishga tushdi")
        log("onDestroy2 ishga tushdi")
    }

    override fun onRestart() {
        super.onRestart()
        toast("onRestart2 ishga tushdi")
        log("onRestart2 ishga tushdi")
    }
    private fun toast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }
    private fun log(msg: String) {
        Log.d("MainActivity@@", msg)
    }
}