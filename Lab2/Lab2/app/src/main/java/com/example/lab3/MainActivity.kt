package com.example.lab3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private var foodList:ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        foodList.add("Hamburger")
        foodList.add("Pizza")
        foodList.add("Mexican")
        foodList.add("American")
        foodList.add("Chinese")

        btn1.setOnClickListener{
            var foodAdded = name.text.toString()
           // if(foodAdded.isNotEmpty()){
                foodList.add(foodAdded)
                print(foodList)
            }
        //}

        btn2.setOnClickListener {
            if(foodList.isNotEmpty()){
           message.text = foodList[Random.nextInt(foodList.size)]
        }
            else{
                message.text = null

            }            }

        }
    }






