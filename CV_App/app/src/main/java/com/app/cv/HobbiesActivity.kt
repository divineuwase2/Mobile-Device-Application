package com.app.cv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_hobbies.*

class HobbiesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hobbies)

        setSupportActionBar(toolbar_hobbies)
        toolbar_hobbies.title

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}