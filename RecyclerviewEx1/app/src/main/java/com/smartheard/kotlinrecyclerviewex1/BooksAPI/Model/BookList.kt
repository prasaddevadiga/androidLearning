package com.smartheard.kotlinrecyclerviewex1.BooksAPI.Model

import com.google.gson.annotations.SerializedName

data class BookList(
    @SerializedName("books")
    val books: List<BookListItem>
)
