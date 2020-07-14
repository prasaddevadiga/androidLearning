package com.smartheard.kotlinrecyclerviewex1.BooksAPI.Model

import com.google.gson.annotations.SerializedName

data class BookListItem(
    @SerializedName("authors")
    val authors: List<String>,
    @SerializedName("categories")
    val categories: List<String>,
    @SerializedName("isbn")
    val isbn: String,
    @SerializedName("longDescription")
    val longDescription: String,
    @SerializedName("pageCount")
    val pageCount: Int,
    @SerializedName("publishedDate")
    val publishedDate: PublishedDate,
    @SerializedName("shortDescription")
    val shortDescription: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("thumbnailUrl")
    val thumbnailUrl: String,
    @SerializedName("title")
    val title: String
)

