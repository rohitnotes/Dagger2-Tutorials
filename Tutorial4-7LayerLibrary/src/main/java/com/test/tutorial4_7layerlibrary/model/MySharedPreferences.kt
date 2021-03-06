package com.test.tutorial4_7layerlibrary.model

import android.content.SharedPreferences


class MySharedPreferences(private val sharedPreferences: SharedPreferences) {
    fun putData(key: String, data: Int) {
        sharedPreferences.edit().putInt(key, data).apply()
    }

    fun getData(key: String): Int {
        return sharedPreferences.getInt(key, 0)
    }

}