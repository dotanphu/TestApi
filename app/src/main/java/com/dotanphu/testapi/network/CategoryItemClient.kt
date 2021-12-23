package com.dotanphu.testapi.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CategoryItemClient {
    private val retrofit = Retrofit.Builder()
        .baseUrl("http://simple-node-app-nkd.herokuapp.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    operator fun invoke(): CategoryItemSerVice {
        return retrofit.create(CategoryItemSerVice::class.java)
    }
}