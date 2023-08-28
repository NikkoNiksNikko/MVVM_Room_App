package com.example.mvvm_room_app.di.modules

import android.app.Application
import org.koin.dsl.module

class AppModule(mApplication: Application) {
    val modules = module {
        single { mApplication }
    }
}