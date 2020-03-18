package com.example.cosmetic

import android.os.Bundle
import android.view.View
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import com.example.cosmetic.desk.DeskFragment
import com.example.cosmetic.home.HomeFragment
import com.example.cosmetic.me.MeFragment
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
        adapter.addFragment(DeskFragment(), "Cosmetic Desk")
        adapter.addFragment(PackageFragment(), "Package")
        adapter.addFragment(MeFragment(), "MyAccount")
        viewPager.adapter = adapter

        bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId){
                R.id.navigation_home -> {
                    val position = 0
                    container.currentItem = position
                    bar_title.text = adapter.getPageTitle(position)
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.navigation_search -> {
                    val position = 1
                    container.currentItem = position
                    bar_title.text = adapter.getPageTitle(position)
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.navigation_desktop -> {
                    val position = 2
                    container.currentItem = position
                    bar_title.text = adapter.getPageTitle(position)
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.navigation_pack -> {
                    val position = 3
                    container.currentItem = position
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.navigation_me -> {
                    val position = 4
                    container.currentItem = position
                    bar_title.text = adapter.getPageTitle(position)
                    return@setOnNavigationItemSelectedListener true
                }
            }

            false
        }

    }

}