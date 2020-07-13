package com.smartheard.kotlinrecyclerviewex1.RestAPI.Model

import com.google.gson.annotations.SerializedName

data class EyeHunt(
    @SerializedName("incomplete_results")
    val incompleteResults: Boolean,
    @SerializedName("items")
    val items: List<Item>,
    @SerializedName("total_count")
    val totalCount: Int
)