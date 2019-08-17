package com.example.cosmetic

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.tab2_fragment.*
import kotlinx.android.synthetic.main.tab2_fragment.view.*

class Tab2Fragment : Fragment() {

    var product :ArrayList<ProductModel> = ArrayList()
    lateinit var rootView :View
    lateinit var downloadProduct: DownloadProduct

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.tab2_fragment, container, false)
        downloadProduct = DownloadProduct()

        downloadCallback()

        return rootView

    }

    private fun initRecyclerView(){

        activity!!.runOnUiThread {
            search_recycler.adapter = SearchAdapter(product, rootView.context)
            search_recycler.layoutManager = LinearLayoutManager(rootView.context)
        }

    }

    private fun downloadCallback(){

        downloadProduct.downloadProduct(object : DownloadProductInterface{
            override fun onSuccessDownloadProduct(productResult: ArrayList<ProductModel>) {
                product = productResult
                activity!!.runOnUiThread {
                    rootView.no_internet_info.visibility = View.GONE
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
        })
    }

}
