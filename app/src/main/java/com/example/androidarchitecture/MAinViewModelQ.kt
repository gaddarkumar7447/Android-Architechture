package com.example.androidarchitecture

import android.content.Context
import androidx.lifecycle.ViewModel
import com.google.gson.Gson

class MAinViewModelQ(val context : Context) : ViewModel(){
    private var quotesList = emptyArray<Quotes>()
    private var index = 0
    init {
        quotesList = loadQuotesFromAssets()
    }

    private fun loadQuotesFromAssets(): Array<Quotes> {
        val inputStream = context.assets.open("Quotes.json")
        val size : Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        return gson.fromJson(json, Array<Quotes> ::class.java)
    }
    fun quotesList() = quotesList[index]
    fun nextQuotes() = quotesList[++index]
    fun prevQuotes() = quotesList[--index]
}