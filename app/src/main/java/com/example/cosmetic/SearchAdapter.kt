package com.example.cosmetic

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.search_item_list.view.*

class SearchAdapter(val productSet: ArrayList<ProductModel>, val context: Context) : RecyclerView.Adapter<SearchAdapter.MyViewHolder>() {

    override fun getItemCount(): Int {
        return productSet.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.titleTv.text = productSet[position].productName
        holder.descriptionTv.text = productSet[position].productDescription
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(context).inflate(R.layout.search_item_list, parent, false))
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val titleTv = itemView.title_tv
        val descriptionTv = itemView.description_tv
    }
}

