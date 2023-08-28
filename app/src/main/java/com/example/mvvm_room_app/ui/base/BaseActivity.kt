package com.example.mvvm_room_app.ui.base

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mvvm_room_app.R

abstract class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(setLayoutId())

        initViews(savedInstanceState)
        initData()
    }

    abstract fun setLayoutId(): Int
    abstract fun initViews(savedInstanceState: Bundle?)
    abstract fun initData()
}