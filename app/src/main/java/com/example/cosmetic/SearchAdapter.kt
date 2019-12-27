package com.example.cosmetic

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.search_item_list.view.*

class SearchAdapter(private val productSet: ArrayList<ProductModel>, private val context: Activity) : RecyclerView.Adapter<SearchAdapter.MyViewHolder>() {

    override fun getItemCount(): Int {
        return productSet.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.titleTv.text = productSet[position].productName
        holder.descriptionTv.text = productSet[position].productDescription
        Glide.with(context).load(productSet[position].productImg).into(holder.productImage)

        holder.searchLayout.setOnClickListener {
            val intent = Intent(context, CosmeticInfoActivity::class.java)
            intent.putExtra(PRODUCT_NAME, productSet[position].productName)
            intent.putExtra(DESCRIPTION, productSet[position].productDescription)
            intent.putExtra(BRAND_NAME, productSet[position].brandName)
            context.startActivity(intent)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(context).inflate(R.layout.search_item_list, parent, false))
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val titleTv = itemView.title_tv!!
        val descriptionTv = itemView.description_tv!!
        val searchLayout = itemView.search_item_layout!!
        val productImage = itemView.productImage!!
    }
}

