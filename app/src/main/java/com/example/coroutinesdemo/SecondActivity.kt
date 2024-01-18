package com.example.coroutinesdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.GlobalScope

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

    }
}