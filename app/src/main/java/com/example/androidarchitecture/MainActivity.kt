package com.example.androidarchitecture

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    lateinit var text : TextView
    //var count = 0

    private lateinit var viewModel : MainViewModel
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        text = findViewById(R.id.textView)
        // Life Cycle Observer
        lifecycle.addObserver(Observer())
        Log.d("TAG", "onCreate Activity")

        // ViewModel Provider
        viewModel= ViewModelProvider(this, MainViewModelFactory(10))[MainViewModel::class.java]

        val click = findViewById<Button>(R.id.button)
        click.setOnClickListener(View.OnClickListener {
            viewModel.onClick()
            dataSave()
        })
        dataSave()
    }

    private fun dataSave(){
        text.text = viewModel.count.toString()
    }
    /*fun clickButton(view: View) {
        count++
        setText()
    }
    fun setText(){
        text.text = count.toString()
    }*/
}