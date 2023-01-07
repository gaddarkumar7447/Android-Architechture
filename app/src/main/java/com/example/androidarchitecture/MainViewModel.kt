package com.example.androidarchitecture

import androidx.lifecycle.ViewModel

class MainViewModel(private val startNumber : Int) : ViewModel() {
    var count : Int = startNumber

    fun onClick(){
        count++
    }

}