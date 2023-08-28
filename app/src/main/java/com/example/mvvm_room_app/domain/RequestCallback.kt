package com.example.mvvm_room_app.domain

interface RequestCallback<T> {
    fun onSuccess(data: T)
    fun onFail(throwable: Throwable)
}