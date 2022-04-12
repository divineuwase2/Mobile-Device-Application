package com.app.cv

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class Login : AppCompatActivity() {
    var shp: SharedPreferences? = null
    var shpEditor: SharedPreferences.Editor? = null
    var edtUserId: EditText? = null
    var edtPassword: EditText? = null
    var btnLogin: Button? = null
    var txtInfo: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_login)
        edtUserId = findViewById(R.id.edtUserid)
        edtUserId?.setText("")
        edtPassword = findViewById(R.id.edtPassword)
        edtPassword?.setText("")
        btnLogin = findViewById(R.id.btnLogin)
        txtInfo = findViewById(R.id.txtInfo)
        shp = getSharedPreferences("myPreferences", MODE_PRIVATE)
        CheckLogin()
        btnLogin?.setOnClickListener(View.OnClickListener {
            if (edtUserId?.getText().toString() == "" || edtPassword?.getText()
                    .toString() == ""
            ) txtInfo?.setText("Please insert userid and password") else DoLogin(
                edtUserId?.getText().toString(), edtPassword?.getText().toString()
            )
        })
    }

    fun CheckLogin() {
        if (shp == null) shp = getSharedPreferences("myPreferences", MODE_PRIVATE)
        val userName = shp!!.getString("divine", "")
        if (userName != null && userName != "") {
            val i = Intent(this@Login, MainActivity::class.java)
            startActivity(i)
            finish()
        }
    }

    fun DoLogin(userid: String?, password: String) {
        try {
            if (password == "123") {
                if (shp == null) shp = getSharedPreferences("myPreferences", MODE_PRIVATE)
                shpEditor = shp!!.edit()
                shpEditor?.putString("name", userid)
                shpEditor?.commit()
                val i = Intent(this@Login, MainActivity::class.java)
                startActivity(i)
                finish()
            } else txtInfo!!.text = "Invalid Credentails"
        } catch (ex: Exception) {
            txtInfo!!.text = ex.message.toString()
        }
    }
}
