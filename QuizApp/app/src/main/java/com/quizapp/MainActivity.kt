package com.quizapp

import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class MainActivity : AppCompatActivity() {
    var score1 = 0
    var score2 = 0
    var points = 0



    var date: LocalDateTime = LocalDateTime.now()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        radio_group.setOnCheckedChangeListener { group, checkedId ->
            val radioGroup: RadioButton = radio_group.findViewById(checkedId)
            val checked = radioGroup.isChecked
            if(checked && radioGroup.text.toString() == "val"){
                score1 += 50
            }else if(checked && radioGroup.text.toString() != "public" && score1>0){
                score1 -=50
            }
        }


        ch2.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked) score2 += 50
        }

        ch1.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked && score2 > 0) score2 -= 50

        }

    }


    fun submit(view: View){

        points = score1 + score2
        val alertResult = AlertDialog.Builder(this)
        alertResult.setTitle("Your Quiz Result")
        val formatter = DateTimeFormatter. ofPattern("MM-dd-yyyy HH:mm:ss")
        val formatedTime = date.format(formatter)
        alertResult.setMessage("Congratulations! You submitted on $formatedTime, You achieved $points%")
        val alert: AlertDialog = alertResult.create()
        alert.show()
        clear()
    }

    fun clear(){
        score1 = 0
        score2 = 0
        points = 0
        ch2.isChecked=false
        ch1.isChecked = false
        rb2.isChecked = false
        rb3.isChecked = false

    }

    fun reset(view : View){
        clear()
    }

}
