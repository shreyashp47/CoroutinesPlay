package com.example.coroutinesdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    private lateinit var  dummy : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dummy = findViewById(R.id.dummy)
/*
        GlobalScope.launch(Dispatchers.IO){
           val result = doNetworkCall()

            Log.d(TAG, "GlobalScope: ${Thread.currentThread().name}")
            withContext(Dispatchers.Main) {
                Log.d(TAG, "withContext: ${Thread.currentThread().name}")
                dummy.text = result
            }
            Log.d(TAG, "onCreate: $result")
        }*/


        runBlocking {
            launch(Dispatchers.IO){
                delay(3000L)
                Log.d(TAG, "runBlocking launch 1: ${Thread.currentThread().name}")
            }
            launch(Dispatchers.IO){
                delay(3000L)
                Log.d(TAG, "runBlocking launch 2: ${Thread.currentThread().name}")
            }
            Log.d(TAG, "runBlocking start: ${Thread.currentThread().name}")
            delay(5000L)
            Log.d(TAG, "runBlocking end: ${Thread.currentThread().name}")
        }



    }


    private suspend fun doNetworkCall(): String{
        delay(5000L)
        return "Hello Network Call!"
    }
}