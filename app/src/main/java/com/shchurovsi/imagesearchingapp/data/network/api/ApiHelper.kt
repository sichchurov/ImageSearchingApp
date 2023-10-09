package com.shchurovsi.imagesearchingapp.data.network.api

import com.shchurovsi.imagesearchingapp.data.network.models.ListImageDto

interface ApiHelper {

    suspend fun searchPhotos(
        query: String,
        page: Int,
        perPage: Int
    ): ListImageDto
}
