package com.smartheard.kotlinrecyclerviewex1.BooksAPI

import android.content.Intent
import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.smartheard.kotlinrecyclerviewex1.BooksAPI.Model.BookListItem
import com.smartheard.kotlinrecyclerviewex1.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.booklist_item_row.view.*
import kotlinx.android.synthetic.main.tour_recyclerview_card.view.*

class BookAdapter(private val books: List<BookListItem>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val book = books[position]
//        holder.bindBook(book)

        Picasso.get()
            .load(book.thumbnailUrl)
            .into(holder.itemView.imgThumbnailImage)

        holder.itemView.txttitle.text = book.title
        holder.itemView.txtshortDescription.text = book.shortDescription
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookAdapter.BookHolder {
        var view = parent.inflate(R.layout.booklist_item_row, false)
        return BookHolder(view)
    }

    override fun getItemCount() = books.size

    class BookHolder(itermView: View): RecyclerView.ViewHolder(itermView), View.OnClickListener {

        private var view: View = itemView
        private var book: BookListItem? = null

        init {
            itermView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
//            val context = itemView.context
//            val showBookIntent = Intent(context, BookDetailActivity::class.java)
//            showBookIntent.putExtra(BOOK_KEY, book)
//
//            context.startActivity(showBookIntent)

            Log.d("RecyclerView", "CLICK!")
        }

        fun bindBook(book: BookListItem) {
            this.book = book

        }

        companion object {
            private val BOOK_KEY = "BOOK"
        }
    }
}

