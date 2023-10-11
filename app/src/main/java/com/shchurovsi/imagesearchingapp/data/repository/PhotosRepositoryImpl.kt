package com.shchurovsi.imagesearchingapp.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import androidx.paging.map
import com.shchurovsi.imagesearchingapp.data.ImagePagingSource
import com.shchurovsi.imagesearchingapp.data.mapper.PhotoMapper
import com.shchurovsi.imagesearchingapp.data.network.api.ApiHelperImpl
import com.shchurovsi.imagesearchingapp.domain.PhotosRepository
import com.shchurovsi.imagesearchingapp.domain.entities.Image
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PhotosRepositoryImpl @Inject constructor(
    private val apiHelperImpl: ApiHelperImpl,
    private val mapper: PhotoMapper
) : PhotosRepository {
    override suspend fun searchPhoto(
        query: String,
        page: Int,
        perPage: Int
    ): LiveData<PagingData<Image>> = MediatorLiveData<PagingData<Image>>().apply {
        val source = Pager(
            config = PagingConfig(
                pageSize = page,
                maxSize = perPage,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                ImagePagingSource(apiHelperImpl, query)
            }
        ).liveData

        addSource(source) {
            value = it.map {
                mapper.mapImageDtoToImageEntity(it)
            }
        }
    }

}
