package com.example.activitylifecycle.sharedpref

import android.content.Context
import android.content.SharedPreferences

class SharedPrefManager(context: Context) {
    private val sharedPreferences: SharedPreferences = context.getSharedPreferences("MyPref2", Context.MODE_PRIVATE)

    fun saveColor(int: Int) {
        val editor = sharedPreferences.edit()
        editor.putInt("color", int)
        editor.apply()
    }
    fun getColor(): Int {
        return sharedPreferences.getInt("color", -1)
    }
    fun clear() {
        sharedPreferences.edit().clear().apply()
    }
}