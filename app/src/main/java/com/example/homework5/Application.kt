package com.example.homework5

import android.app.Application
import com.example.homework5.network.ServiceConnector

class Application : Application() {
    override fun onCreate() {
        super.onCreate()
        ServiceConnector.init()

    }
}