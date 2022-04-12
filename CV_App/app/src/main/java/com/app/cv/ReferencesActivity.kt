package com.app.cv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_references.*

class ReferencesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_references)

        setSupportActionBar(toolbar_ref)
        toolbar_ref.title

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}