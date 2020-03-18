package com.example.cosmetic.getobject

interface DownloadProductInterface {

    fun onSuccessDownloadProduct(productResult: ArrayList<ProductModel>)
    fun onFailedDownloadProduct(errorDescription: String)

}