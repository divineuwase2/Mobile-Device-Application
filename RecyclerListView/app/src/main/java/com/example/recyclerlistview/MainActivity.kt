package com.example.recyclerlistview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    var r1: RecyclerView? = null
    var layoutManager: RecyclerView.LayoutManager? = null
    var productList = ArrayList<Product>(arrayListOf(
        Product("Lenovo Tablet",380.10,"Black",R.drawable.lenovo_tab.toString(),"101","The Lenovo Tab P11 Pro tablet has a beautiful OLED display and strong speakers for playing games and watching movies, but it's not ideal for productivity."),
        Product("XP-Printer ",442.10,"Black",R.drawable.xp_printer.toString(),"102","This printer is designed for use with Epson cartridges only, not third party cartridges or ink; Cartridges described as Compatible, Re-manufactured, refilled or refillable may not work properly or at all"),
        Product("Hp Laptop",480.10,"Silver",R.drawable.hp_laptop.toString(),"104","The HP 17 Laptop is thoughtfully designed and delivers performance with an AMD processor, fast Wi-Fi technology, and loads of storage. Enjoy a more natural and comfortable typing position with the lift-hinge design and enlarged click pad. The HP 17 design includes sustainable materials like ocean-bound plastic and from post-consumer recycled plastic."),
        Product("Samsung Monitor",610.75,"Silver",R.drawable.samsung_monitor.toString(),"105","Featuring an ultra-slim and sleek profile the Samsung CF398 monitor measures less than 0.5 inch thick. Make a stylish statement while staying productive with the 27 inch curved screen. The simple circular stand will add a modern look to your space.")
    ))
    var myAdapter : MyAdapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        r1 = findViewById<RecyclerView>(R.id.rv)

        myAdapter = MyAdapter(this,productList)
        layoutManager = LinearLayoutManager(this)
        r1?.layoutManager = layoutManager
        r1?.adapter = myAdapter

    }
}