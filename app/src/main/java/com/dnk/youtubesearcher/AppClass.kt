package com.dnk.youtubesearcher

import android.app.Application
import android.util.Log

class AppClass: Application() {
    val TAG = "AppClass"

    val repository by lazy { Repository() }

    companion object {
        lateinit var instance: AppClass
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}