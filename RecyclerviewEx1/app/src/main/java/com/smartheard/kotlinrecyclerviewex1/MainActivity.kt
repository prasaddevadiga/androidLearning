package com.smartheard.kotlinrecyclerviewex1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.smartheard.kotlinrecyclerviewex1.BlogPostList.BlogPostList
import com.smartheard.kotlinrecyclerviewex1.Tourism.PlaceListView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnRecycler1.setOnClickListener {
            val intent = Intent(this, BlogPostList::class.java)
            startActivity(intent)
        }

        btnTourism.setOnClickListener {
            val intent = Intent(this, PlaceListView::class.java)
            startActivity(intent)
        }
    }


}
