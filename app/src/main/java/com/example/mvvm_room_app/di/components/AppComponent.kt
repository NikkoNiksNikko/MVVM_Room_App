package com.example.mvvm_room_app.di.components

import android.app.Application
import com.example.mvvm_room_app.di.modules.*
import org.koin.core.module.Module

class AppComponent(application: Application) {
    val modules: List<Module> = listOf(
        DatabaseModule().modules,
        DaoModule().module,
        RepositoryModule().modules,
        UseCasesModule().modules
    )
}