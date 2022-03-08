package com.example.walmart

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.et1
import kotlinx.android.synthetic.main.activity_main.et2
import kotlinx.android.synthetic.main.activity_register.*

class Register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
    }

    fun createUser(view: View) {
        var fName: String = et1.text.toString()
        var lName: String = et2.text.toString()
        var email: String = et3.text.toString()
        var password: String = et4.text.toString()
        if(fName.isNotEmpty() && lName.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()){
        //   var newUser= User(fName, lName, email, password)
            var resultIntent=Intent()
       //     resultIntent.putExtra("newUser", newUser)
            resultIntent.putExtra("email", email)
            resultIntent.putExtra("password", password)
            resultIntent.putExtra("firstname", fName)
            resultIntent.putExtra("lastname", lName)
            setResult(RESULT_OK, resultIntent)
            finish()

        }else{
          Toast.makeText(this, "An error occurred, please enter your information again.", Toast.LENGTH_SHORT).show()
        }

    }
}