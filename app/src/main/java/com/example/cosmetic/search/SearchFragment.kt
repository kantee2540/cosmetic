package com.example.cosmetic.search

import android.os.Bundle
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

class SearchFragment : Fragment(), DownloadProductInterface {

    private var product :ArrayList<ProductModel> = ArrayList()
    private lateinit var rootView :View
    private lateinit var downloadProduct: DownloadProduct

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.search_fragment, container, false)
        downloadProduct = DownloadProduct(this)

        downloadCallback()

        return rootView

    }

    private fun initRecyclerView(){

        activity!!.runOnUiThread {
            search_recycler.adapter = SearchAdapter(product, activity!!)
            search_recycler.layoutManager = LinearLayoutManager(rootView.context)
        }

        search_refresh.setOnRefreshListener {
            downloadCallback()
        }

    }

    override fun onSuccessDownloadProduct(productResult: ArrayList<ProductModel>) {
        product = productResult
        activity!!.runOnUiThread {
            rootView.no_internet_info.visibility = View.GONE
        }

        initRecyclerView()
        search_refresh.isRefreshing = false
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
