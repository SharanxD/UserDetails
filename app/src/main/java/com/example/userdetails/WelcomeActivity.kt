package com.example.userdetails

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val name = findViewById<EditText>(R.id.edtname)
        val age = findViewById<EditText>(R.id.edtage)
        val phone= findViewById<EditText>(R.id.edtphone)
        val hobby = findViewById<EditText>(R.id.edthobby)

        val SubmitButton= findViewById<AppCompatButton>(R.id.edtbtn)
        val showButton=findViewById<AppCompatButton>(R.id.edtshow)
        SubmitButton.setOnClickListener{
            Log.d("Welcome Activity",name.text.toString())
            val dbHelper= DBHelper(this,null)

            dbHelper.addFriendToUserDetails(name.text.toString(),
                age.text.toString(),
                phone.text.toString(),
                hobby.text.toString()
            )


            Toast.makeText(this@WelcomeActivity,"User added successfully!",Toast.LENGTH_LONG).show()

            name.text?.clear()
            age.text?.clear()
            phone.text?.clear()
            hobby.text?.clear()
        }

        showButton.setOnClickListener() {
            val intent = Intent(this, UserListActivity::class.java)
            startActivity(intent)
        }
    }
}