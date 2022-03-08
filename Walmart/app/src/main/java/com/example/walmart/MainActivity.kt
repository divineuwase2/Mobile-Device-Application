package com.example.walmart

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
     var users= ArrayList<User>()
    var correctDetailsFlag=false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val user=User("Divine", "Uwase", "duwase@gmail.com", "1234")
        val user1 = User("Kevin", "Spark", "kspark@gmail.com", "2345")
        val user2 = User("Steven", "M'call", "smcall@gmail.com", "3456")
        val user3 = User("Caroline", "Williams", "cwilliams@gmail.com", "4567")
        val user4 = User("Kenny", "Rogers", "krogers@gmail.com", "5678")
        val user5 = User("Tania", "Grant", "tgrant@gmail.com", "6789")
        users.add(user1)
        users.add(user2)
        users.add(user3)
        users.add(user4)
        users.add(user5)

    }
    fun login(view:View) {
        for (i in users) {
            val uname: String = i.userName
            val upassword: String = i.password
            if (et1.text.toString().equals(uname) && et2.text.toString().equals(upassword)) {
                correctDetailsFlag = true

                    var intent = Intent(this, ShopByCategory::class.java)
                    intent.putExtra("user", uname)
                    startActivity(intent)
                    break

            }

        }
    }

    fun createAccount(view: View){
        val intent = Intent(this,Register::class.java)
        startActivity(intent)

    }
    @Suppress("DEPRECATION")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==1){
            if(resultCode == Activity.RESULT_OK){
                if(data != null){
                    val ReturnedResult = data.getSerializableExtra("newUser") as User
                    users.add(ReturnedResult)
                    Toast.makeText(this, "Account created successfully with user name of ${ReturnedResult.userName}", Toast.LENGTH_LONG).show()
                }

            }
        }
    }

    fun forgetPassword(view: View){
        var userName = et1.text.toString()
        var password = et2.text.toString()

        if(!userName.equals("") && !password.equals("")){
            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra("Password", password)
            intent.type = "text/plain"
            startActivity((Intent.createChooser(intent, "Password sent to your email address")))
        }  else {
            Toast.makeText(this, "Wrong Email or Password", Toast.LENGTH_SHORT).show()
        }
    }
    }

