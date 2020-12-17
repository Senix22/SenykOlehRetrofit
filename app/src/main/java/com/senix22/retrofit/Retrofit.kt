package com.senix22.retrofit

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.StringBuilder


const val BASE_URL = "https://cat-fact.herokuapp.com"

fun main() {
    getMyDate()
}

fun getMyDate() {
    val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()
        .create(Catsapi::class.java)

    val repos  = retrofit.getData()

    repos .enqueue(object : Callback<List<CatsItem>?> {
        override fun onResponse(call: Call<List<CatsItem>?>, response: Response<List<CatsItem>?>) {
           val responseBody = response.body()!!

            val myStringBuilder= StringBuilder()
            for (myDate in responseBody){
                myStringBuilder.apply {
                    append(myDate.status)
                    append(myDate.text)
                    append(myDate.type)
                    append(myDate._id)
                    append(myDate.source)

                }

            }
            println(myStringBuilder)
        }

        override fun onFailure(call: Call<List<CatsItem>?>, t: Throwable) {

        }
    })

}

