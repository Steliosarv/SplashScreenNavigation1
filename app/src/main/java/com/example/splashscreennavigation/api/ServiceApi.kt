package com.example.splashscreennavigation.api

import com.example.splashscreennavigation.models.ApiResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ServiceApi {


    companion object{
        const val BASE_URL="https://api.tvmaze.com/"
        const val END_POINT = "/shows"

    }

    @GET(BASE_URL)
    suspend fun getTvShows(): Response<ApiResponse>


    fun provideRetrofitInstance(BASE_URL: String): ServiceApi =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ServiceApi::class.java)


}