package com.example.activitylifecycle.util

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.Button

fun Context.start(activity: Activity) {
    startActivity(Intent(this, activity::class.java))
}
fun Button.click(click: (View) -> Unit) {
    this.setOnClickListener {
        click(it)
    }
}