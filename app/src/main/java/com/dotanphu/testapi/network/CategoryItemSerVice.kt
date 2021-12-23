package com.dotanphu.testapi.network

import com.dotanphu.testapi.model.CategoryItem
import retrofit2.Call
import retrofit2.http.GET

interface CategoryItemSerVice {
    @GET(".")
    fun getAllCategoryItem(): Call<List<CategoryItem>>
}