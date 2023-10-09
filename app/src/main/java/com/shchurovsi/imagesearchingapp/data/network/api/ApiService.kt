package com.shchurovsi.imagesearchingapp.data.network.api

import com.shchurovsi.imagesearchingapp.BuildConfig
import com.shchurovsi.imagesearchingapp.data.network.models.ListImageDto
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiService {

    companion object {
        private const val API_KEY = BuildConfig.API_KEY
    }

    @Headers("Accept-Version: v1", "Authorization: Client-ID $API_KEY")
    @GET("search/photos")
    suspend fun searchPhotos(
        @Query("query") query: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): ListImageDto
}
