package com.example.cosmetic

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class Tab3Fragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater,  container: ViewGroup?,  savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.tab3_fragment, container, false)

    }

    companion object {

        private val TAG = "Tab1Frangment"
    }
}
