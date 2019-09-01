package com.example.cosmetic

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.tab2_fragment.*
import kotlinx.android.synthetic.main.tab2_fragment.view.*

class Tab2Fragment : Fragment(), DownloadProductInterface {

    var product :ArrayList<ProductModel> = ArrayList()
    lateinit var rootView :View
    lateinit var downloadProduct: DownloadProduct

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.tab2_fragment, container, false)
        downloadProduct = DownloadProduct(this)

        downloadCallback()

        return rootView

    }

    private fun initRecyclerView(){

        activity!!.runOnUiThread {
            search_recycler.adapter = SearchAdapter(product, rootView.context)
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
