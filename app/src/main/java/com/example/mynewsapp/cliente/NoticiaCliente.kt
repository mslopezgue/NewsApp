package com.example.mynewsapp.cliente

import com.example.mynewsapp.service.APIService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NoticiaCliente {
    companion object{
        private val URL_BASRE ="https://newsapi.org/"

        fun getCliente(url: String): APIService {
            val retrofit = Retrofit.Builder().baseUrl(url).addConverterFactory(
                GsonConverterFactory.create()).build()
            return retrofit.create(APIService::class.java)
        }
    }
}
