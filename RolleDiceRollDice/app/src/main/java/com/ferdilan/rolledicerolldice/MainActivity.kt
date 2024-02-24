package com.ferdilan.rolledicerolldice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.view.View
import android.widget.*

const val EXTRA_MESSAGE = "com.ferdilan.rolldicerolldice.MESSAGE"
var listjawaban: MutableList <String> = mutableListOf<String>()
class MainActivity : AppCompatActivity() {
    lateinit var diceImage : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.roll_button1)
        rollButton.setOnClickListener { rollDice() }
        diceImage = findViewById(R.id.dice_image)

        val rollButton2: Button = findViewById(R.id.roll_button2)
        rollButton2.setOnClickListener { rollDice2() }
        diceImage = findViewById(R.id.dice_image2)

        val btncek: Button = findViewById(R.id.btncek)
        btncek.setOnClickListener { cek() }

    }



    private fun rollDice(){
        val resultText: TextView = findViewById(R.id.result_text1)

        val randomInt = (1..6).random()
        val diceImage: ImageView = findViewById(R.id.dice_image)
        val drawableResource = when (randomInt){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        val randomInt2 = (1..6).random()
        val diceImage2: ImageView = findViewById(R.id.dice_image2)
        val drawableResource2 = when (randomInt2) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        diceImage.setImageResource(drawableResource)
        diceImage2.setImageResource(drawableResource2)
        val hasil1 = (randomInt.toInt()+randomInt2).toInt()
        resultText.text = hasil1.toString()
    }




    private fun rollDice2(){
        val resultText2: TextView = findViewById(R.id.result_text2)

        val randomInt2 = (1..6).random()
        val diceImage2: ImageView = findViewById(R.id.dice_image2)
        val drawableResource2 = when (randomInt2){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        val randomInt = (1..6).random()
        val diceImage: ImageView = findViewById(R.id.dice_image)
        val drawableResource = when (randomInt){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        diceImage2.setImageResource(drawableResource2)
        diceImage.setImageResource(drawableResource)
        val hasil2 = (randomInt.toInt()+randomInt2).toInt()
        resultText2.text = hasil2.toString()
    }



    private fun cek() {

        val bilanganpertama: TextView = findViewById(R.id.result_text1)
        val bilangankedua: TextView = findViewById(R.id.result_text2)
        val cek: EditText = findViewById(R.id.editjawaban)
        val salahbenar: TextView = findViewById(R.id.salahbenar)
        val hasiltambah: TextView = findViewById(R.id.hasiltambah)
        val total = bilanganpertama.text.toString().toInt() + bilangankedua.text.toString().toInt()
        hasiltambah.text = total.toString()

        //if else
        val total2 = total.toString()
        val tambah2 = cek.text.toString()
        val input = cek.getText().toString()

        if (input.isEmpty()){
            Toast.makeText(this, "jawaban harus diisi",
                Toast.LENGTH_SHORT).show()
        }
        else
            if (total2 == tambah2){
                salahbenar.text = "jawaban benar"
                listjawaban.add("BENAR")
            }
            else{
                salahbenar.text = "jawaban salah"
                listjawaban.add("SALAH")
            }
    }

    fun sendMessage(view: View) {
        val hasil = findViewById<TextView>(R.id.salahbenar)
        val message = hasil.text.toString()
        val intent = Intent(this, DisplayMessageActivity::class.java).apply{
            putExtra(EXTRA_MESSAGE, message)
        }
        startActivity(intent)
    }
}