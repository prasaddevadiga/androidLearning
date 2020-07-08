package com.smartheard.kotlinrecyclerviewex1.BlogPostList

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.smartheard.kotlinrecyclerviewex1.R
import kotlinx.android.synthetic.main.recycler_view_1.*

class BlogPostList: AppCompatActivity() {

    private  lateinit var blogAdapter: BlogRecyclerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recycler_view_1)
        initRecyclerView()
        addDataSet()
    }

    private fun addDataSet() {
        var data = Datasource.createDataSet()
        blogAdapter.submitList(data)
    }


    private fun initRecyclerView() {
        recycler_view.apply {
            layoutManager = LinearLayoutManager(this@BlogPostList)
            val decoration =
                TopSpacingItemDecoration(30)
            addItemDecoration(decoration)
            blogAdapter = BlogRecyclerAdapter()
            adapter = blogAdapter
        }
    }
}

