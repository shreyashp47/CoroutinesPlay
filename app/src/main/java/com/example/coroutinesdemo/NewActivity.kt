package com.example.coroutinesdemo

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout

class NewActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    private lateinit var  dummy : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val job = GlobalScope.launch(Dispatchers.Default) {
//            repeat(5){
//                Log.d(TAG,"Coroutine is still working ")
//                delay(1000L)
//            }

            Log.d(TAG,"Starting long running task")
            withTimeout(2000L) {
            for (i in 40..50){
                if (isActive)
                Log.d(TAG,"Coroutine is still working $i: ${fibonacci(i)}")
                else break
            }}
            Log.d(TAG,"Ending long running task")


        }

//        runBlocking {
//            delay(2000L)
//            job.cancel()
//            Log.d(TAG, "Job cancelled")
//        }


    }



    //fibunacci fun
    fun fibonacci(n: Int): Long {
        return if (n==0) 0
        else if (n==1) 1
        else fibonacci(n-1) + fibonacci(n-2)

    }
}