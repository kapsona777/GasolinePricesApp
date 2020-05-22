package com.example.goapp

import android.util.Log.d
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

object DataLoader {

    var retrofit = Retrofit.Builder().addConverterFactory(ScalarsConverterFactory.create())
        .baseUrl("https://gas-price.p.rapidapi.com/")
        .build()

    var service: ApiRetrofit = retrofit.create<ApiRetrofit>(ApiRetrofit::class.java)
    fun getRequest(path: String, CustomCallback:CustomCallback) {
        val call = service.getRequest(path)
        call.enqueue(Callback(CustomCallback))
        d("first:","Done......")

    }

    private fun Callback(CustomCallback : CustomCallback) = object : Callback<String> {
        override fun onFailure(call: Call<String>, t: Throwable) {
                d("error","${t.message}")
        }

        override fun onResponse(call: Call<String>, response: Response<String>) {
            d("Succes","${response.body().toString()}")
            CustomCallback.onSuccess(response.body().toString())
        }

    }
}
interface ApiRetrofit {
    @Headers("x-rapidapi-key:60f7183781msh04c9ac1de580bdcp19e9fejsn65f493573779")
    @GET("{path}")
    fun getRequest(@Path("path") user: String?): Call<String>
}