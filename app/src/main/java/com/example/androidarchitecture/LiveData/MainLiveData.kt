package com.example.androidarchitecture.LiveData

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.androidarchitecture.R

class MainLiveData : AppCompatActivity() {
    lateinit var liveModelView: LiveModelView
    lateinit var textLive : TextView
    lateinit var button : Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_live_data)
        supportActionBar?.hide()
        textLive = findViewById(R.id.textLive)
        button = findViewById(R.id.buttonChange)
        liveModelView = ViewModelProvider(this)[LiveModelView::class.java]

        liveModelView.liveData.observe(this, Observer {
            textLive.text = it
        })

        button.setOnClickListener(View.OnClickListener {
            liveModelView.changeLiveData()
        })

    }
}