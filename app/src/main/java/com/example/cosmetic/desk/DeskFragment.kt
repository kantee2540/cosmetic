package com.example.cosmetic.desk

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cosmetic.R

class DeskFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater,  container: ViewGroup?,  savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.desk_fragment, container, false)

    }

    companion object {

        private val TAG = "Tab1Frangment"
    }
}
