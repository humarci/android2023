package com.example.filedemo1

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    internal lateinit var ed1: EditText
    internal lateinit var ed2: EditText
    internal lateinit var ed3: EditText
    internal lateinit var b1: Button
    internal lateinit var b2: Button

    val MyPreferences = "MyPrefs"
    val nameK = "nameKey"
    val phoneK = "phoneKey"
    val emailK = "emailKey"

    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ed1 = findViewById(R.id.etName)
        ed2 = findViewById(R.id.etPass)
        ed3 = findViewById(R.id.etEmail)

        b1 = findViewById(R.id.btnSave)
        b2 = findViewById(R.id.btnLoad)
        sharedPreferences = getSharedPreferences(MyPreferences, Context.MODE_PRIVATE)

        b1.setOnClickListener(View.OnClickListener {
            val name = ed1.text.toString()
            val phone = ed2.text.toString()
            val email = ed3.text.toString()

            val editor = sharedPreferences.edit()

            editor.putString(nameK, name)
            editor.putString(phoneK, phone)
            editor.putString(emailK, email)
            editor.commit()
            Toast.makeText(this@MainActivity, "Done", Toast.LENGTH_LONG).show()
        })

        b2.setOnClickListener(View.OnClickListener {
            ed1.setText(sharedPreferences.getString(nameK, ""))
            ed2.setText(sharedPreferences.getString(phoneK, ""))
            ed3.setText(sharedPreferences.getString(emailK, ""))

            Toast.makeText(this@MainActivity, "Loaded", Toast.LENGTH_LONG).show()
        })

    }
}