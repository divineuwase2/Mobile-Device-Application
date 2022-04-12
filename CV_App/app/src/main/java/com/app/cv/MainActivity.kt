package com.app.cv

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.menu.MenuBuilder
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    var txtInfo: TextView? = null
    var btnLogOut: Button? = null

    var shp: SharedPreferences? = null
    var shpEditor: SharedPreferences.Editor? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        setupViewPager(viewPager)
        setUpIcons()

        txtInfo = findViewById(R.id.txtInfo)
        btnLogOut = findViewById(R.id.btnLogOut)
        shp = getSharedPreferences("myPreferences", MODE_PRIVATE)
        CheckLogin()

        btnLogOut?.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                Logout()
            }
        })
    }


    private fun setupViewPager(viewPager: ViewPager){ //private method to set up the swipe views
        val  viewPagerAdapter= ViewPagerAdapter(supportFragmentManager)
        viewPagerAdapter.addFragment(HomeFragment(), "Home")
        viewPagerAdapter.addFragment(ABOUT(), "ABOUT ME")
        viewPagerAdapter.addFragment(Skills(), "Skills")
        viewPagerAdapter.addFragment(Work(), "Work")

        viewPager.adapter=viewPagerAdapter
    }

    private fun setUpIcons(){
        tabLayout.setupWithViewPager(viewPager)
        tabLayout.getTabAt(0)!!.setIcon(R.drawable.icon_home)
        tabLayout.getTabAt(1)!!.setIcon(R.drawable.icon_about_me)
        tabLayout.getTabAt(2)!!.setIcon(R.drawable.icon_skills)
        tabLayout.getTabAt(3)!!.setIcon(R.drawable.icon_work)
    }

    private fun  CheckLogin() {
        if (shp == null)
            shp = getSharedPreferences("myPreferences", MODE_PRIVATE);


        var userName = shp?.getString("name", "");

        if (userName != null && !userName.equals("")) {
            txtInfo?.setText("Welcome " + userName);

        } else
        {
            var loginIntent = Intent(this@MainActivity, Login::class.java);
            startActivity(loginIntent);
            finish();
        }
    }


    fun Logout() {
        try {
            if (shp == null) shp = getSharedPreferences("myPreferences", MODE_PRIVATE)
            shpEditor = shp!!.edit()
            shpEditor?.putString("name", "")
            shpEditor?.commit()
            val i = Intent(this@MainActivity, Login::class.java)
            startActivity(i)
            finish()
        } catch (ex: Exception) {
            Toast.makeText(this@MainActivity, ex.message.toString(), Toast.LENGTH_LONG).show()
        }
    }

    @SuppressLint("RestrictedApi")
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
       // menu?.clear()
        menuInflater.inflate(R.menu.menu_main, menu);
        if(menu is MenuBuilder) {
            menu.setOptionalIconsVisible(true)
        }

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val intentContact= Intent(this, ContactActivity::class.java)
        val intentHobbies= Intent(this, HobbiesActivity::class.java)
        val intentReferences=Intent(this, ReferencesActivity::class.java)
        return when(item.itemId) {

            R.id.action_contact -> {
                startActivity(intentContact)
                return true
            }
            R.id.action_hobbies -> {
                startActivity(intentHobbies)
                return true
            }

            R.id.action_references -> {
                startActivity(intentReferences)
                return true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }
}