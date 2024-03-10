package com.mju.hongpak

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.net.URL
import java.util.concurrent.Executors

class HotelAdapter (private val hotelList: ArrayList<HotelItem>) : RecyclerView.Adapter<HotelAdapter.HotelViewHolder>() {

    class HotelViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val hotelName: TextView = itemView.findViewById(R.id.hotel_name)
        val hotelLocation: TextView = itemView.findViewById(R.id.hotel_location)
        val hotelPrice: TextView = itemView.findViewById(R.id.hotel_price)
        val hotelImage: ImageView = itemView.findViewById(R.id.hotel_image)
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

        val executor = Executors.newSingleThreadExecutor()
        val handler = Handler(Looper.getMainLooper())
        var image: Bitmap?
        executor.execute(fun() {
            val url = currentItem.imageUrl
            val `in` = URL(url).openStream()
            image = BitmapFactory.decodeStream(`in`)
            handler.post {
                holder.hotelImage.setImageBitmap(image)
            }
        })
    }

    override fun getItemCount() = hotelList.size
}