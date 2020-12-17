package com.senix22.retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface Catsapi {
    @GET("facts")
    fun getData() : Call<List<CatsItem>>

}