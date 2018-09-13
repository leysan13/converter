package com.leyka1398.converter

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("convert")
    fun search(@Query("q") query: String,
               @Query("compact") compact: String): Call<Result>

    companion object Factory {
        fun create(): ApiInterface {
            val retrofit = Retrofit.Builder()

                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("https://free.currencyconverterapi.com/api/v6/")
                    .build()

            return retrofit.create(ApiInterface::class.java);
        }
    }
}