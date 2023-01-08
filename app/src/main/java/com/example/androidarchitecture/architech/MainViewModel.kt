package com.example.androidarchitecture.architech

import androidx.lifecycle.ViewModel

class MainViewModel(private val startNumber : Int) : ViewModel() {
    var count : Int = startNumber

    fun onClick(){
        count++
    }

}