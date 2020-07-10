package com.smartheard.kotlinrecyclerviewex1.Tourism

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.smartheard.kotlinrecyclerviewex1.R
import com.smartheard.kotlinrecyclerviewex1.Tourism.CustomZoomClass.CustomZoomLayout
import com.smartheard.kotlinrecyclerviewex1.Tourism.TourAdapter.PlaceDatasource
import com.smartheard.kotlinrecyclerviewex1.Tourism.TourAdapter.TourAdapter

class PlaceListView: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.place_list_view)
        this.setTitle("Tourism")

        // init views
        val tourRV = findViewById<RecyclerView>(R.id.tourRecyclerView)

        // init layout managers

        val layoutManager = CustomZoomLayout(this)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        layoutManager.reverseLayout = true
        layoutManager.stackFromEnd = true

        tourRV.layoutManager = layoutManager

        // to auto center views

        val snapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(tourRV)
        tourRV.isNestedScrollingEnabled = false

        tourRV.adapter = TourAdapter(this, PlaceDatasource.createDataSet())
    }
}