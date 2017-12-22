package com.mercan.minuteur

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var text: TextView? = null
    private val manager: AlarmBasicDateManager = AlarmBasicDateManagerImpl.getInstance()
    private val listener: AlarmBasicDateManager.EndListener = AlarmBasicDateManager.EndListener {
        Log.d("jm/debug", "End")
        text!!.text = "Fin"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        text = findViewById(R.id.activity_main_text)

        findViewById<View>(R.id.activity_main_button).setOnClickListener {
            Log.d("jm/debug", "Start")
            manager.start()
        }

        manager.registerEndListener(listener)
    }

    override fun onDestroy() {
        manager.unregisterEndListener(listener)
        super.onDestroy()
    }
}
