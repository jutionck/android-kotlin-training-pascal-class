package com.example.pascalandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    // Lifecycle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i("test", "onCreate() initiated moving onStart()")
    }

    // override all method
    override fun onStart() {
        super.onStart()
        Log.i("test", "onStart() initiated moving onResume()")
    }

    override fun onResume() {
        super.onResume()
        Log.i("test", "onResume() waiting for onPause()")
    }

    override fun onPause() {
        super.onPause()
        Log.i("test", "onPause() waiting for onStop() or onResume()")
    }

    override fun onStop() {
        super.onStop()
        Log.i("test", "onStop() waiting for onDestroy() or onRestart()")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("test", "onRestart() initiated moving to onStart()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("test", "onDestroy() initiated...the app has been killed...")
    }
}