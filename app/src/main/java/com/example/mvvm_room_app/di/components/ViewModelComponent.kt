package com.example.mvvm_room_app.di.components

import com.example.mvvm_room_app.di.modules.ViewModelModule
import org.koin.core.module.Module

class ViewModelComponent {
    val modules : List<Module> = listOf(
        ViewModelModule().modules
    )
}