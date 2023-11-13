package com.shchurovsi.imagesearchingapp.domain

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import com.shchurovsi.imagesearchingapp.domain.entities.Image

interface PhotosRepository {
    fun searchPhoto(
        query: String,
        page: Int,
        perPage: Int
    ): LiveData<PagingData<Image>>
}
