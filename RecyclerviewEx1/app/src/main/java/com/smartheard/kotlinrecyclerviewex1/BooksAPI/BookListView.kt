package com.smartheard.kotlinrecyclerviewex1.BooksAPI

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.smartheard.kotlinrecyclerviewex1.R
import com.google.gson.annotations.SerializedName
import com.smartheard.kotlinrecyclerviewex1.BooksAPI.Model.BookList
import com.smartheard.kotlinrecyclerviewex1.RestAPI.Model.EyeHunt
import kotlinx.android.synthetic.main.book_list.*
import kotlinx.android.synthetic.main.recycler_view_1.*
import org.json.JSONException


class BookListView : AppCompatActivity() {

    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var adapter: BookAdapter
    private var requestQueue: RequestQueue? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.book_list)

        requestQueue = Volley.newRequestQueue(this)
        linearLayoutManager = LinearLayoutManager(this)
        bookListRecyclerView.layoutManager = linearLayoutManager

        this.setTitle("Book list")
        loadBookList()
    }

    private fun loadBookList() {
        val url = "http://demo1767891.mockable.io/booklist"
//        val url = "https://github.com/bvaughn/infinite-list-reflow-examples/blob/master/books.json"
        val request = JsonObjectRequest(Request.Method.GET, url, null, Response.Listener { response ->
            try {
                var strResp = response.toString()
                val booklist = Gson().fromJson(strResp, BookList::class.java)

                adapter = BookAdapter(booklist.books)
                bookListRecyclerView.adapter = adapter

            } catch (e: JSONException) {
                e.printStackTrace()
            }
        }, Response.ErrorListener { error ->
            error.printStackTrace()
        })
        requestQueue?.add(request)



    }
}
