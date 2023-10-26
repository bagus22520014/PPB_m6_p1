package com.example.ppb_m6_p1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.Toast
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onRbClicked(view: View) {
        if (view is RadioButton) {
            val checked = view.isChecked

            when (view.id) {
                R.id.rb_pria -> {
                    if (checked) {
                        Toast.makeText(applicationContext, "on click : ${view.text}", Toast.LENGTH_SHORT).show()
                    }
                }
                R.id.rb_wanita -> {
                    if (checked) {
                        Toast.makeText(applicationContext, "on click : ${view.text}", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    fun onCbClicked(view: View) {
        if (view is CheckBox) {
            val checked: Boolean = view.isChecked
            when (view.id) {
                R.id.cb_coding -> {
                    val message = if (checked) {
                        "${view.text} terpilih"
                    } else {
                        "${view.text} tidak terpilih"
                    }
                    Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
                }
                R.id.cb_traveling -> {
                    val message = if (checked) {
                        "${view.text} terpilih"
                    } else {
                        "${view.text} tidak terpilih"
                    }
                    Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
                }
                R.id.cb_cooking -> {
                    val message = if (checked) {
                        "${view.text} terpilih"
                    } else {
                        "${view.text} tidak terpilih"
                    }
                    Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    fun onBtnProsesClicked(view: View) {
        val etNama = findViewById<EditText>(R.id.etNama)
        val rbPria = findViewById<RadioButton>(R.id.rb_pria)
        val rbWanita = findViewById<RadioButton>(R.id.rb_wanita)
        val cbCoding = findViewById<CheckBox>(R.id.cb_coding)
        val cbTraveling = findViewById<CheckBox>(R.id.cb_traveling)
        val cbCooking = findViewById<CheckBox>(R.id.cb_cooking)
        val tvPesan = findViewById<TextView>(R.id.tvPesan)

        val nama = etNama.text.toString()
        val kelamin = if (rbPria.isChecked) "Pria" else "Wanita"
        val hobi = mutableListOf<String>()

        if (cbCoding.isChecked) {
            hobi.add("Coding")
        }
        if (cbTraveling.isChecked) {
            hobi.add("Traveling")
        }
        if (cbCooking.isChecked) {
            hobi.add("Cooking")
        }

        val greeting = if (rbPria.isChecked) "Mas" else "Mbak"
        val hobiString = hobi.joinToString(", ")

        val message = "$greeting $nama, kamu suka $hobiString"

        tvPesan.text = message
    }

}