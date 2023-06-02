package com.example.randomizer.remote.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.randomizer.remote.model.MainResponse
import com.example.randomizer.remote.service.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository(private val api: ApiService) {

    fun getUsers(): LiveData<MainResponse> {
        val liveData = MutableLiveData<MainResponse>()
        api.getUsers().enqueue(object : Callback<MainResponse> {
            override fun onResponse(call: Call<MainResponse>, response: Response<MainResponse>) {
                if (response.isSuccessful && response.body() != null) {
                    liveData.value = response.body()
                }
            }

            override fun onFailure(call: Call<MainResponse>, t: Throwable) {
                Log.e("ololo", t.localizedMessage ?: "Current error!")
            }
        })
        return liveData
    }
}