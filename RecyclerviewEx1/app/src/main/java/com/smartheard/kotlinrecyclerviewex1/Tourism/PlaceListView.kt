package com.smartheard.kotlinrecyclerviewex1.Tourism

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.smartheard.kotlinrecyclerviewex1.R
import com.smartheard.kotlinrecyclerviewex1.Tourism.CustomZoomClass.CustomZoomLayout
import com.smartheard.kotlinrecyclerviewex1.Tourism.TourAdapter.TourAdapter
import com.smartheard.kotlinrecyclerviewex1.Tourism.model.Places
import org.intellij.lang.annotations.JdkConstants

class PlaceListView: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.place_list_view)

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

        val places = ArrayList<Places>()

        places.add(
            Places(
                "Los angels",
                "officially the City of Los Angeles and often known by its initials L.A. is the largest city in California With an estimated population of nearly four million people",
                4.5f,
                "https://images.unsplash.com/photo-1534190760961-74e8c1c5c3da?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1950&q=80"
        ))

        places.add(
            Places(
                "India",
                "India, officially the Republic of India (Hindi: Bhārat Gaṇarājya),[23] is a country in South Asia. It is the second-most populous country, the seventh-largest country by area",
                4.5f,
                "https://images.unsplash.com/photo-1524492412937-b28074a5d7da?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1951&q=80"
            ))

        places.add(
            Places(
                "Rajastan",
                "Rajasthan (/ˈrɑːdʒəstæn/ Hindustani pronunciation: [raːdʒəsˈtʰaːn] (About this soundlisten); literally, \"Land of Kings\")[8] is a state in northern India.[9][10][11] The state covers an area of 342,239 square kilometres (132,139 sq mi) or 10.4 percent of the total geographical area of India",
                4.5f,
                "https://images.unsplash.com/photo-1591661585188-04fce214708d?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=2220&q=80"
            ))


        tourRV.adapter = TourAdapter(this, places)
    }
}