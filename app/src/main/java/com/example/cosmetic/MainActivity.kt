package com.example.cosmetic

import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private var mSectionsPageAdapter: SectionsPageAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mSectionsPageAdapter = SectionsPageAdapter(supportFragmentManager)
        setupViewPager(container)

    }

    private fun setupViewPager(viewPager: ViewPager) {
        val adapter = SectionsPageAdapter(supportFragmentManager)

        adapter.addFragment(Tab1Fragment(), "Home")
        adapter.addFragment(Tab2Fragment(), "Search")
        adapter.addFragment(Tab3Fragment(), "Camera")
        adapter.addFragment(Tab4Fragment(), "Account")
        viewPager.adapter = adapter
        tabs1.setupWithViewPager(container)

        tabs1.getTabAt(0)!!.setIcon(R.drawable.ic_home)
        tabs1.getTabAt(1)!!.setIcon(R.drawable.ic_search)
        tabs1.getTabAt(2)!!.setIcon(R.drawable.ic_camera)
        tabs1.getTabAt(3)!!.setIcon(R.drawable.ic_account)
    }

}