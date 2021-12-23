package com.dotanphu.testapi.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CategoryItem(
    @Expose
    @SerializedName("id")
    val id: Int,
    @Expose
    @SerializedName("title")
    val title: String,
    @Expose
    @SerializedName("description")
    val description: String,
    @Expose
    @SerializedName("image")
    val image: String
)