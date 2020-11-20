package com.example.cosmetic.search

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cosmetic.getobject.DownloadProduct
import com.example.cosmetic.getobject.DownloadProductInterface
import com.example.cosmetic.R
import com.example.cosmetic.getobject.ProductModel
import kotlinx.android.synthetic.main.search_fragment.*
import kotlinx.android.synthetic.main.search_fragment.view.*
import java.lang.Exception

class SearchFragment : Fragment(), DownloadProductInterface {

    private var product :ArrayList<ProductModel> = ArrayList()
    private lateinit var rootView :View
    private lateinit var downloadProduct: DownloadProduct

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.search_fragment, container, false)
        downloadProduct = DownloadProduct(this)

        downloadCallback()

        rootView.search_refresh.setOnRefreshListener {
            downloadCallback()
        }

        return rootView

    }

    private fun initRecyclerView(){

        activity!!.runOnUiThread {
            try {
                rootView.search_recycler.adapter = SearchAdapter(product, rootView.context)
                rootView.search_recycler.layoutManager = LinearLayoutManager(rootView.context)
            }catch (e: Exception){
                Log.e("Error", e.toString())
            }

        }

    }

    override fun onSuccessDownloadProduct(productResult: ArrayList<ProductModel>) {
        product = productResult
        activity!!.runOnUiThread {
            rootView.no_internet_info.visibility = View.GONE
            rootView.search_refresh.isRefreshing = false
        }

        initRecyclerView()
    }

    override fun onFailedDownloadProduct(errorDescription: String) {
        activity!!.runOnUiThread {
            rootView.no_internet_info.visibility = View.VISIBLE
            rootView.error_code.text = errorDescription
        }
        rootView.try_again_btn.setOnClickListener {
            downloadCallback()
        }
    }

    private fun downloadCallback(){
        downloadProduct.downloadProduct()
    }

}
