package com.example.mynewsapp.service

import com.example.mynewsapp.model.NoticiaModel
import com.example.mynewsapp.utils.Constantes.Companion.API_KEY
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {
    @GET
        ("v2/top-headlines")
suspend fun getData(
    @Query("country")
    codigo: String = "us",
    @Query("apiKey")
    apiKey: String = API_KEY,
): Call<NoticiaModel>

    @GET("v2/everything")
    suspend fun getSearchNews(
        @Query(value = "q", encoded = true)
        q: String,
        @Query("idioma")
        lenguage: String ="es",
        @Query(value = "apiKey")
        apiKey: String = API_KEY,
        @Query(value = "pageSize") pageSize: Int = 50
    ): Call<NoticiaModel>
}