package com.example.coroutinesdemo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout

class LifeCycleScopeActivity : AppCompatActivity() {

    private val TAG = "LifeCycleScopeActivity"

    private lateinit var dummy: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        dummy = findViewById(R.id.dummy)
        dummy.setText("Click here")


        dummy.setOnClickListener {
            lifecycleScope.launch {
                while (true) {
                    delay(1000L)
                    Log.d(TAG, "Still running")
                }
            }
            GlobalScope.launch {
                delay(3000L)
                val intent = Intent(this@LifeCycleScopeActivity, SecondActivity::class.java)
                startActivity(intent)
                finish()

            }
        }


    }


}