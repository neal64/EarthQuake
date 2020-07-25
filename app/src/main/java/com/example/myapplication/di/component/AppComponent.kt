package com.example.myapplication.di.component

import android.content.Context
import com.example.myapplication.di.modules.AppModule
import com.example.myapplication.di.modules.NetworkingModule
import com.example.myapplication.view.fragments.HomeFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, NetworkingModule::class])
interface AppComponent {
    fun inject(fragment: HomeFragment)
    fun inject(context: Context)
}