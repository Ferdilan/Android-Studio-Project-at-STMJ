package com.ferdilan.arrayproject

import android.R.layout.simple_list_item_1
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity


const val EXTRA_MESSAGE = "com.ferdilan.arrayproject.MESSAGE"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // data yang akan kita tampilkan ke dalam ListView
        val languages  = listOf("Java", "Kotlin", "JavaScript", "PHP", "Python")
        val lv_languange = findViewById<ListView>(R.id.lv_languages)

        // memberikan adapter ke ListView
        lv_languange.adapter = ArrayAdapter(this, simple_list_item_1, languages)

        //menangani item saat diklik
        lv_languange.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this, "Anda memilih: ${languages[position]}",Toast.LENGTH_SHORT).show()
        }
    }


    /** Dipanggil saat pengguna mengetuk tombol Send */
    fun sendMessage(view: View) {
        val editText = findViewById<EditText>(R.id.editTextTextPersonName)
        val message = editText.text.toString()
        val intent = Intent(this, DisplayMessageActivity::class.java).apply{
            putExtra(EXTRA_MESSAGE, message)
        }
        startActivity(intent)
    }
}