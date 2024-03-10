package com.mju.hongpak

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONObject

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

        val sampleData = JSONObject("""
            {
                "hotels": [
                    {
                        "name": "Hotel 1",
                        "location": "Location 1",
                        "price": 100,
                        "imageUrl": "https://img.freepik.com/free-photo/painting-mountain-lake-with-mountain-background_188544-9126.jpg"
                    },
                    {
                        "name": "Hotel 2",
                        "location": "Location 2",
                        "price": 200,
                        "imageUrl": "https://www.cpbrandsite.com/contents/recipe/e0de7xjshvfytkpdbe5djiajahz5kwms6kifnaur.png"
                    },
                    {
                        "name": "Hotel 3",
                        "location": "Location 3",
                        "price": 300,
                        "imageUrl": "https://img.freepik.com/free-photo/painting-mountain-lake-with-mountain-background_188544-9126.jpg"
                    }
                ]
            }
        """)

        for (i in 0 until sampleData.getJSONArray("hotels").length()) {
            val hotel = sampleData.getJSONArray("hotels").getJSONObject(i)
            hotelList.add(HotelItem(hotel.getString("name"), hotel.getString("location"), hotel.getInt("price"), hotel.getString("imageUrl")))
        }
        hotelAdapter = HotelAdapter(hotelList)
        recyclerView.adapter = hotelAdapter
    }
}
