package com.shchurovsi.imagesearchingapp.data.repository

import com.shchurovsi.imagesearchingapp.data.mapper.PhotoMapper
import com.shchurovsi.imagesearchingapp.data.network.api.ApiHelperImpl
import com.shchurovsi.imagesearchingapp.domain.PhotosRepository
import com.shchurovsi.imagesearchingapp.domain.entities.ListImage
import javax.inject.Inject

class PhotosRepositoryImpl @Inject constructor(
    private val apiHelperImpl: ApiHelperImpl,
    private val mapper: PhotoMapper
) : PhotosRepository {
    override suspend fun searchPhoto(query: String, page: Int, perPage: Int): ListImage {
        return mapper.mapListImageToListImageDto(
            apiHelperImpl.searchPhotos(query, page, perPage)
        )
    }

}
