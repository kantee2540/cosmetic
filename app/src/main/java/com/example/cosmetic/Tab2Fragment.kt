package com.example.cosmetic

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.tab2_fragment.*
import okhttp3.*
import org.json.JSONArray
import org.json.JSONObject
import java.io.IOException

class Tab2Fragment : Fragment() {

    var product :ArrayList<ProductModel> = ArrayList()
    lateinit var rootView :View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.tab2_fragment, container, false)
        downloadProduct()

        return rootView

    }

    private fun downloadProduct(){
        val client = OkHttpClient()
        val productUrl = BuildConfig.server_url + "getProduct.php"
        val request = Request.Builder()
                .url(productUrl)
                .build()

        client.newCall(request).enqueue(object : Callback{
            override fun onFailure(call: Call, e: IOException) {
                Log.e("Failed", "Error!!")
            }

            override fun onResponse(call: Call, response: Response) {

                val strResponse = response.body!!.string()
                val jsonArray = JSONArray(strResponse)

                for (i in 0 until jsonArray.length()){
                    val jsonObject = jsonArray.getJSONObject(i)

                    val productModel = ProductModel()
                    productModel.productName = jsonObject.getString("product_name")
                    productModel.productDescription = jsonObject.getString("description")
                    productModel.productPrice = jsonObject.getString("product_price")
                    productModel.categoriesName = jsonObject.getString("categories_name")
                    productModel.categoriesType = jsonObject.getString("categories_type")
                    productModel.brandName = jsonObject.getString("brand_name")
                    productModel.productImg = jsonObject.getString("product_img")

                    product.add(productModel)
                }

                initRecyclerView()

            }
        })
    }

    private fun initRecyclerView(){

        activity!!.runOnUiThread {
            search_recycler.adapter = SearchAdapter(product, rootView.context)
            search_recycler.layoutManager = LinearLayoutManager(rootView.context)
        }


    }
}
