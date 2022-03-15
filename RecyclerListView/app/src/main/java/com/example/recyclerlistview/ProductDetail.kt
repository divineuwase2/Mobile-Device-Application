package com.example.recyclerlistview

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_product_detail.*

class ProductDetail  : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)
        // To avoid application crashing check intent has data or not
        if(intent.hasExtra("product")) {
            val product=intent.getSerializableExtra("product") as Product
            name.text = product.title
            name3.text="Price : $ " + product.price.toString()
            name4.text="Color : " + product.color
            name5.text="Item Id : " + product.itemId
            desc.text = product.desc.toString()
            imageView.setImageResource(product.image.toInt())
        }
    }
}