package com.app.cv

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

@Suppress("DEPRECATION")
class ViewPagerAdapter(fm:FragmentManager): FragmentPagerAdapter(fm) {//used for swipable views
    private val fragments= mutableListOf<Fragment>()
    private val fragmentTitle= mutableListOf<String>()

    fun addFragment(fragment: Fragment, title:String){
        fragments.add(fragment)
        fragmentTitle.add(title)
    }

    override fun getCount(): Int {
        return fragments.size

    }

    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    override fun getPageTitle(position: Int): CharSequence {
        return fragmentTitle[position]
    }
}