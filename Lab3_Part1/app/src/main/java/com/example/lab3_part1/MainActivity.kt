package com.example.lab3_part1

import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.TableRow
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



    }


   fun add(view: View) {
       // Create a new table row.
       val tableRow = TableRow(getApplicationContext()) // this
       // Set new table row layout parameters.
       val layoutParams = TableRow.LayoutParams(
           TableRow.LayoutParams.MATCH_PARENT,
           TableRow.LayoutParams.WRAP_CONTENT
       )
       layoutParams.setMargins(0, 20, 0, 10)
       layoutParams.gravity = Gravity.BOTTOM
       tableRow.layoutParams = layoutParams

       val version = TextView(this)
       version.text = version.text
       layoutParams.gravity = Gravity.BOTTOM
       version.layoutParams = layoutParams


       val code = TextView(this)
       version.text = code.text
       layoutParams.gravity = Gravity.BOTTOM
       version.layoutParams = layoutParams

// add values into row by calling addView()
       tableRow.addView(version,0)
       tableRow.addView(code,1)
// Finally add the created row row into layout
       table.addView(tableRow) // id from Layout_file
   }


}