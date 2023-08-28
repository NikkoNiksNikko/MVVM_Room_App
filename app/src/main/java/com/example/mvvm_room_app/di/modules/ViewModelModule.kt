package com.example.mvvm_room_app.di.modules

import com.example.mvvm_room_app.ui.viewModels.ProductViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

class ViewModelModule {
    val modules = module {
        viewModel { ProductViewModel(get()) }
    }
}