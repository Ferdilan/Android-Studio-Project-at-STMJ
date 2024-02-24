package com.example.projectarray

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.widget.TextView

class DisplayMessageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_message)

        //Dapatkan Intent yang memulai aktivitas ini ekstrat string
        val message = intent.getStringExtra(EXTRA_MESSAGE)
        //Tangkap TextView sebagai tata letak dan atur string sebagai teks nya
        val textView = findViewById<TextView>(R.id.textView3).apply {
            text = message
        }
    }
}