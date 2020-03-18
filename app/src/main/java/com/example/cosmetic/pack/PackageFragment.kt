package com.example.cosmetic.pack

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cosmetic.R

class PackageFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.package_fragment, container, false)

    }

    companion object {

        private val TAG = "Tab2Frangment"
    }
}
