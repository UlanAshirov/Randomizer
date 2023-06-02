package com.example.randomizer.remote.service

import com.example.randomizer.remote.model.MainResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("api/users")
    fun getUsers(): Call<MainResponse>
}