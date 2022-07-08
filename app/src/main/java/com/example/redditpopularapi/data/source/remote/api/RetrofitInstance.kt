package com.example.redditpopularapi.data.source.remote.api

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val gson = Gson()
        .newBuilder()
        .setLenient()
        .create()
    val api: ApiService by lazy {
        val adapter = Retrofit.Builder()
            .baseUrl("https://www.reddit.com/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(OkhttpClientInstance.getOkHttpClientBuilder())
            .build()
        adapter.create(ApiService::class.java)
    }
}