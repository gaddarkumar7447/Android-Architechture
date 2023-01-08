package com.example.androidarchitecture

import android.annotation.SuppressLint
import android.app.Application
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.androidarchitecture.DataBinding.MainDataBinding
import com.example.androidarchitecture.LiveData.MainLiveData
import com.example.androidarchitecture.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var bindingDataClass : ActivityMainBinding
    /*late init var text : TextView
    //var count = 0

    private late init var viewModel : MainViewModel
    @SuppressLint("MissingInflatedId")*/

    lateinit var mAinViewModelQ: MAinViewModelQ
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingDataClass = DataBindingUtil.setContentView(this, R.layout.activity_main)
        supportActionBar?.hide()

        mAinViewModelQ = ViewModelProvider(this, MainViewModelFactoryQuotes(application))[MAinViewModelQ::class.java]

        val next = findViewById<TextView>(R.id.nextButton)
        val previous = findViewById<TextView>(R.id.previousButton)
        val quotesText = findViewById<TextView>(R.id.quoteText)
        val quotesAuthor = findViewById<TextView>(R.id.quoteAuthor)
        next.setOnClickListener(View.OnClickListener {
            mAinViewModelQ.nextQuotes()
            quotesText.text = mAinViewModelQ.quotesList().text
            quotesAuthor.text = mAinViewModelQ.quotesList().author
        })

        previous.setOnClickListener(View.OnClickListener {
            mAinViewModelQ.prevQuotes()
            quotesText.text = mAinViewModelQ.quotesList().text
            quotesAuthor.text = mAinViewModelQ.quotesList().author
        })

        quotesText.text = mAinViewModelQ.quotesList().text
        quotesAuthor.text = mAinViewModelQ.quotesList().author

        bindingDataClass.liveData.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this, MainLiveData::class.java))
        })


        /*text = findViewById(R.id.textView)
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
        dataSave()*/
    }

    fun dataBindingFun(view: View) {
        startActivity(Intent(this, MainDataBinding::class.java))
    }


    /*private fun dataSave(){
        text.text = viewModel.count.toString()
    }
    *//*fun clickButton(view: View) {
        count++
        setText()
    }
    fun setText(){
        text.text = count.toString()
    }*/
}