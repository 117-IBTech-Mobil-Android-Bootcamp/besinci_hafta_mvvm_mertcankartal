package com.example.homework5.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class TablayoutAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager) {

    private val fragmentList: MutableList<Fragment> = ArrayList()
    private val titleList: MutableList<String> = ArrayList()

    //Fragment size
    override fun getCount(): Int {
        return fragmentList.size
    }

    //Fragment's position
    override fun getItem(position: Int): Fragment {
        return fragmentList[position]
    }

    //add fragments and their titles
    fun addFragment(fragment: Fragment, title: String) {
        fragmentList.add(fragment)
        titleList.add(title)
    }
    //Title's position
    override fun getPageTitle(position: Int): CharSequence {
        return titleList[position]
    }
}