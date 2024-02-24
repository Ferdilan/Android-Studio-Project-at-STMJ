package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val myName: MyName = MyName("Ferdilan")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.myName = myName
        binding.doneButton.setOnClickListener {
            addNickname(it)
        }

        binding.tampilnama.setOnClickListener{
            updatenama(it)
        }
    }

    private fun addNickname(view: View){
        //menyembunyikan keyboard
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)

        binding. apply {
            myName?.nickname = editNama.text.toString()
            invalidateAll()
            tampilnama.text = editNama.text
            editNama.visibility = View.GONE
            view.visibility = View.GONE
            tampilnama.visibility = View.VISIBLE
        }

    }

    private fun updatenama(view: View){
        val editNama = findViewById<EditText>(R.id.edit_nama)
        val doneButton = findViewById<TextView>(R.id.done_button)

        editNama.visibility = View.VISIBLE
        doneButton.visibility = View.VISIBLE
        view.visibility = View.GONE

        //autofocus ke edittext
        editNama.requestFocus()

        //membuat keyboard terlihat
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(editNama, 0)
    }
}