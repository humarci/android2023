package com.example.filedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    lateinit var btnSave:Button
    lateinit var btnLoad:Button
    lateinit var tv:TextView
    lateinit var et:EditText

    private var data:String? = null
    private val file = "myData"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSave = findViewById(R.id.btnSave)
        btnLoad = findViewById(R.id.btnLoad)

        et = findViewById(R.id.etInput)
        tv = findViewById(R.id.tvOutput)

        btnSave.setOnClickListener(View.OnClickListener {
            data = et.text.toString()
            try {
                val fOut = openFileOutput(file, MODE_PRIVATE)
                fOut.write(data!!.toByteArray())
                fOut.close()
                Toast.makeText(baseContext, "File saved!", Toast.LENGTH_LONG).show()
            } catch (e: Exception) {
                // do something else...
                e.printStackTrace()
            }
        })

        btnLoad.setOnClickListener(View.OnClickListener {
            try {
                val fIn = openFileInput(file)
                var c: Int
                var temp = ""

                while (fIn.read().also { c = it } != -1) {
                    temp += Character.toString(c.toChar())
                }

                tv.setText(temp)
                Toast.makeText(baseContext, "File loaded!", Toast.LENGTH_LONG).show()

            } catch (e: Exception) {
                // do something else...
                e.printStackTrace()
            }
        })
    }
}