package com.pushpendra.practice.android.adapterviews

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item_layout.view.*

class ListitemAdapter(private val exampleList: List<ItemViewClass>) :
    RecyclerView.Adapter<ListitemAdapter.ListitemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListitemViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.list_item_layout,
            parent, false
        )
        return ListitemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ListitemViewHolder, position: Int) {

        val currentItem = exampleList[position]
        holder.itemImage.setImageResource(currentItem.imageResource)
        holder.text1.text = currentItem.text1
        holder.text2.text = currentItem.text2

        if (position == 0) {
            holder.itemImage.setColorFilter(Color.RED)
        }else {
            holder.itemImage.setColorFilter(Color.BLACK)
        }
    }

    override fun getItemCount(): Int = exampleList.size


    class ListitemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        //hooks for the itemview
        val itemImage: ImageView = itemView.item_view_image
        val text1: TextView = itemView.item_text_view_1
        val text2: TextView = itemView.item_text_view_2
    }
}