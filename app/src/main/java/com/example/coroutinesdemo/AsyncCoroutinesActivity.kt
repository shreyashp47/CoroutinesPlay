package com.example.coroutinesdemo

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout

class AsyncCoroutinesActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    private lateinit var dummy: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScope.launch (Dispatchers.IO){

            val result = async{ doNetworkCall()}
            val result2 = async{ doNetworkCall2()}

            Log.d(TAG, "Result : ${result.await()}")
            Log.d(TAG, "Result2 : ${result2.await()}")

        }


    }


    suspend fun doNetworkCall(): String {
        delay(5000L)
        return "Network call 1"
    }

    suspend fun doNetworkCall2(): String {
        delay(5000L)
        return "Network call 2"
    }
}