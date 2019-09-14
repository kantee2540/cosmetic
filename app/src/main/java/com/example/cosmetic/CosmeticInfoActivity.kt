package com.example.cosmetic

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;

import kotlinx.android.synthetic.main.activity_cosmetic_info.*
import kotlinx.android.synthetic.main.content_cosmetic_info.*

class CosmeticInfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cosmetic_info)
        setSupportActionBar(toolbar)

        product_textview.text = intent.getStringExtra(PRODUCT_NAME)
        description_textview.text = intent.getStringExtra(DESCRIPTION)
        toolbar.title = intent.getStringExtra(BRAND_NAME)

        toolbar.setNavigationOnClickListener { finish() }

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

}
