package com.example.myapplication.di

import android.app.Application
import com.example.myapplication.di.component.AppComponent
import com.example.myapplication.di.component.DaggerAppComponent
import com.example.myapplication.di.modules.AppModule
import com.example.myapplication.di.modules.NetworkingModule


@Suppress("DEPRECATION")
class BaseApplication : Application() {
    lateinit var applicationComponent : AppComponent

    override fun onCreate() {
        super.onCreate()
        applicationComponent = this.getAppComponent()!!
    }

    fun getAppComponent(): AppComponent? {
        return DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .networkingModule(NetworkingModule())
            .build()
    }

}
