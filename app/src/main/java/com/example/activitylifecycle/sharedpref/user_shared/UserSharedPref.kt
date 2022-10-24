package com.example.activitylifecycle.sharedpref.user_shared

import android.content.Context
import android.content.SharedPreferences
import com.example.activitylifecycle.sharedpref.model.User
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class UserSharedPref(context: Context) {
    private val sharedPref: SharedPreferences =
        context.getSharedPreferences("UserPref", Context.MODE_PRIVATE)

    private val gson = Gson()

    fun saveUser(user: User) {
        val editor = sharedPref.edit()
        editor.putString("user", gson.toJson(user))
        editor.apply()
    }

    fun getUser(): User? {
        val json = sharedPref.getString("user", null)
        val type = object : TypeToken<User>() {}.type
        return gson.fromJson(json, type)
    }

    fun clearUser() {
        sharedPref.edit().clear().apply()
    }
}