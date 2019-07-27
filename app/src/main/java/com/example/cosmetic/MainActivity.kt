package com.example.cosmetic

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private var mSectionsPageAdapter: SectionsPageAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mSectionsPageAdapter = SectionsPageAdapter(supportFragmentManager)
        setupViewPager(container)
        tabs1.setupWithViewPager(container)


    }

    private fun setupViewPager(viewPager: ViewPager) {
        val adapter = SectionsPageAdapter(supportFragmentManager)

        adapter.addFragment(Tab1Fragment(), "Home")
        adapter.addFragment(Tab2Fragment(), "Search")
        adapter.addFragment(Tab3Fragment(), "Camera")
        adapter.addFragment(Tab4Fragment(), "Account")
        viewPager.adapter = adapter
    }

}