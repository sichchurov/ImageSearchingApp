package com.shchurovsi.imagesearchingapp.domain

import com.shchurovsi.imagesearchingapp.domain.entities.ListImage

interface PhotosRepository {
    suspend fun searchPhoto(
        query: String,
        page: Int,
        perPage: Int
    ): ListImage
}
