package com.mju.hongpak

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HotelAdapter (private val hotelList: ArrayList<HotelItem>) : RecyclerView.Adapter<HotelAdapter.HotelViewHolder>() {

    class HotelViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val hotelName: TextView = itemView.findViewById(R.id.hotel_name)
        val hotelLocation: TextView = itemView.findViewById(R.id.hotel_location)
        val hotelPrice: TextView = itemView.findViewById(R.id.hotel_price)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotelViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.hotel_item, parent, false)
        return HotelViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: HotelViewHolder, position: Int) {
        val currentItem = hotelList[position]

        holder.hotelName.text = currentItem.name
        holder.hotelLocation.text = currentItem.location
        holder.hotelPrice.text = currentItem.price.toString()
    }

    override fun getItemCount() = hotelList.size
}