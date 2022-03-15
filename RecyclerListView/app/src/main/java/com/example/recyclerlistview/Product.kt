package com.example.recyclerlistview

import java.io.Serializable

data class Product (val title:String, val price:Double, val color:String, val image:String, val itemId:String, val desc:String):Serializable
//serialize object to pass through intent