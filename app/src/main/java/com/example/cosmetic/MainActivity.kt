package com.example.cosmetic

import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
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