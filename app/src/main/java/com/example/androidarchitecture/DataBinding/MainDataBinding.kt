package com.example.androidarchitecture.DataBinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.androidarchitecture.R
import com.example.androidarchitecture.databinding.ActivityMainDataBindingBinding

class MainDataBinding : AppCompatActivity() {
    lateinit var dataBinding: ActivityMainDataBindingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main_data_binding)
        supportActionBar?.hide()

        /*dataBinding.text1.text = "Do nad die"
        dataBinding.text2.text = "Veer"*/
        val quo = QuotesData("Do and die", "veerYodha")
        dataBinding.quotes = quo


    }
}