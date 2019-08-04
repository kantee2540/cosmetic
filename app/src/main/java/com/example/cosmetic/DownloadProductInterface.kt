package com.example.cosmetic

interface DownloadProductInterface {

    fun onSuccessDownloadProduct(productResult: ArrayList<ProductModel>)
    fun onFailedDownloadProduct(errorDescription: String)

}