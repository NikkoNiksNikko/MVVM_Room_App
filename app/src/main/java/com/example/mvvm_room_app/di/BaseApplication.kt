package com.example.mvvm_room_app.di

import android.app.Application
import com.example.mvvm_room_app.di.components.AppComponent
import com.example.mvvm_room_app.di.components.ViewModelComponent
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level


class BaseApplication : Application() {
    val mAppComponent = AppComponent(this)
    val mViewModelComponent = ViewModelComponent()

    override fun onCreate() {
        super.onCreate()
        sInstance = this

        initKoin()
    }

    private fun initKoin(){
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@BaseApplication)
            modules(mAppComponent.modules + mViewModelComponent.modules)
        }
    }

    companion object{
        lateinit var sInstance : BaseApplication
            private set
    }
}