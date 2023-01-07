package com.example.androidarchitecture

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    var count : Int = 0

    fun onClick(){
        count++
    }

}