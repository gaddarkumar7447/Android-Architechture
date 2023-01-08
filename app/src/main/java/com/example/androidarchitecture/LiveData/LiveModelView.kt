package com.example.androidarchitecture.LiveData

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LiveModelView : ViewModel() {
    // Two type of live data
    // 1. Mutable lIve data (We can change the data)
    // 2. lIve data (Read only)

    val liveData = MutableLiveData<String>("This is the fact")

    fun changeLiveData(){
        liveData.value = "Gaddar Kumar Chaudhary"
    }
}