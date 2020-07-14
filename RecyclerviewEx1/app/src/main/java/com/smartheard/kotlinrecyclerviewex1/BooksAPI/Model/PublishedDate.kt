package com.smartheard.kotlinrecyclerviewex1.BooksAPI.Model

import com.google.gson.annotations.SerializedName

data class PublishedDate(
    @SerializedName("date")
    val date: String
)