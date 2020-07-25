package com.example.myapplication.di.modules

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule (val app : Application) {

    @Provides
    @Singleton
    fun provideContext() : Application =  app
}