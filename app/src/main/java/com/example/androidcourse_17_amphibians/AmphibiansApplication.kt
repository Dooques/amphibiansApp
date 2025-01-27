package com.example.androidcourse_17_amphibians

import android.app.Application
import com.example.androidcourse_17_amphibians.data.AppContainer
import com.example.androidcourse_17_amphibians.data.DefaultAppContainer

class AmphibiansApplication: Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}