package com.example.baseandroid.features.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.baseandroid.R

class DeliveryHistoryAdapter(private val deliveryItemList: List<DeliveryItem>) : RecyclerView.Adapter<DeliveryHistoryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_delivery_history, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val deliveryItem = deliveryItemList[position]

        holder.restaurantNameTextView.text = deliveryItem.restaurantName
        holder.deliveryDateTextView.text = deliveryItem.deliveryDate
        holder.deliveryStatusTextView.text = deliveryItem.deliveryStatus
    }

    override fun getItemCount(): Int {
        return deliveryItemList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val restaurantNameTextView: TextView = itemView.findViewById(R.id.restaurantNameTextView)
        val deliveryDateTextView: TextView = itemView.findViewById(R.id.deliveryDateTextView)
        val deliveryStatusTextView: TextView = itemView.findViewById(R.id.deliveryStatusTextView)
    }
}