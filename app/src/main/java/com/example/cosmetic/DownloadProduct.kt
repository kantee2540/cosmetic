package com.example.cosmetic

import android.util.Log
import okhttp3.*
import org.json.JSONArray
import java.io.IOException

class DownloadProduct {

    var product: ArrayList<ProductModel> = ArrayList()

    fun downloadProduct(callBack: DownloadProductInterface){
        val client = OkHttpClient()
        val productUrl = BuildConfig.server_url + "getProduct.php"
        val request = Request.Builder()
                .url(productUrl)
                .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.e("Failed", "Cannot connect to server : $productUrl")
                callBack.onFailedDownloadProduct(e.message.toString())
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

                    callBack.onSuccessDownloadProduct(product)

                }



            }
        })

    }
}