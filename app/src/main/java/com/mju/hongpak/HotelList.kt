package com.mju.hongpak

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HotelList : AppCompatActivity() {

    private lateinit var hotelAdapter: HotelAdapter
    private lateinit var hotelList: ArrayList<HotelItem>
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hotel_list)

        hotelList = ArrayList()
        recyclerView = findViewById(R.id.hotelListView)
        recyclerView.setHasFixedSize(false)
        recyclerView.layoutManager = LinearLayoutManager(this)

        hotelList.add(HotelItem("Hotel 1", "Location 1", 100))
        hotelList.add(HotelItem("Hotel 2", "Location 2", 200))
        hotelList.add(HotelItem("Hotel 2", "Location 2", 200))
        hotelList.add(HotelItem("Hotel 2", "Location 2", 200))
        hotelList.add(HotelItem("Hotel 2", "Location 2", 200))
        hotelList.add(HotelItem("Hotel 2", "Location 2", 200))
        hotelList.add(HotelItem("Hotel 2", "Location 2", 200))

        hotelAdapter = HotelAdapter(hotelList)
        recyclerView.adapter = hotelAdapter
    }
}
