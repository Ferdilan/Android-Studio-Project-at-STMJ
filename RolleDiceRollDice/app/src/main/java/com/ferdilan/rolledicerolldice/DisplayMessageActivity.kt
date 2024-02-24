package com.ferdilan.rolledicerolldice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import android.widget.ListView
import android.widget.TextView

class DisplayMessageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_message)

        val message = intent.getStringExtra(EXTRA_MESSAGE)

        val textView = findViewById<TextView>(R.id.textviewhaldua).apply {
            text = message
        }
        val listview = findViewById<ListView>(R.id.listjawaban)
        listview.adapter=ArrayAdapter(this, android.R.layout.simple_list_item_1, listjawaban)
    }
}