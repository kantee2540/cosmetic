package com.example.cosmetic

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class Tab1Fragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.tab1_fragment, container, false)

    }

    companion object {

        private val TAG = "Tab1Frangment"
    }
}
