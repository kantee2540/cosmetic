package com.example.cosmetic.getobject

import android.util.Log
import com.example.cosmetic.BuildConfig
import okhttp3.*
import org.json.JSONArray
import java.io.IOException

const val PRODUCT_NAME = "product_name"
const val DESCRIPTION = "description"
const val PRODUCT_PRICE = "product_price"
const val CATEGORIES_NAME = "categories_name"
const val CATEGORIES_TYPE = "categories_type"
const val BRAND_NAME = "brand_name"
const val PRODUCT_IMG = "product_img"

class DownloadProduct(private val callBack: DownloadProductInterface) {

    var product: ArrayList<ProductModel> = ArrayList()

    fun downloadProduct(){
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
                    productModel.productName = jsonObject.getString(PRODUCT_NAME)
                    productModel.productDescription = jsonObject.getString(DESCRIPTION)
                    productModel.productPrice = jsonObject.getString(PRODUCT_PRICE)
                    productModel.categoriesName = jsonObject.getString(CATEGORIES_NAME)
                    productModel.categoriesType = jsonObject.getString(CATEGORIES_TYPE)
                    productModel.brandName = jsonObject.getString(BRAND_NAME)
                    productModel.productImg = jsonObject.getString(PRODUCT_IMG)

                    product.add(productModel)

                    callBack.onSuccessDownloadProduct(product)

                }
            }
        })

    }
}