package com.example.coroutinesdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScope.launch{
           val result = doNetworkCall()
            Log.d(TAG, "onCreate: $result")

        }
        Log.d(TAG, "onCreate: ${Thread.currentThread().name}")
    }


    private suspend fun doNetworkCall(): String{
        delay(300L)
        Log.d(TAG, "doNetworkCall: ${Thread.currentThread().name}")
        return "Hello Network Call!"
    }
}