package com.example.walmart

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class ShopByCategory:AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop_by_category)
        val intent = intent
        val outPut = intent.getStringExtra("user")
        tv1.text = "welcome $outPut"

    }
    fun selectedProduct(view: View){
        val result=when(view.id){
            R.id.img1->"Electronics"
            R.id.img2->"Clothing"
            R.id.img3->"Beauty"
            else->"Food"
        }
        Toast.makeText(this, "You have chosen the $result category of shopping", Toast.LENGTH_LONG).show()
    }
}