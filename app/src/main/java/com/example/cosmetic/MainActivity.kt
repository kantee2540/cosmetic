package com.example.cosmetic

import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import com.example.cosmetic.desk.DeskFragment
import com.example.cosmetic.home.HomeFragment
import com.example.cosmetic.pack.PackageFragment
import com.example.cosmetic.search.SearchFragment
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

        adapter.addFragment(HomeFragment(), "Home")
        adapter.addFragment(SearchFragment(), "Search")
        adapter.addFragment(DeskFragment(), "Camera")
        adapter.addFragment(PackageFragment(), "Account")
        viewPager.adapter = adapter

        bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId){
                R.id.navigation_home -> {
                    container.currentItem = 0
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.navigation_search -> {
                    container.currentItem = 1
                    return@setOnNavigationItemSelectedListener true
                }
            }

            false
        }
//        tabs1.setupWithViewPager(container)
//
//        tabs1.getTabAt(0)!!.setIcon(R.drawable.ic_home)
//        tabs1.getTabAt(1)!!.setIcon(R.drawable.ic_search)
//        tabs1.getTabAt(2)!!.setIcon(R.drawable.ic_camera)
//        tabs1.getTabAt(3)!!.setIcon(R.drawable.ic_account)
    }

}