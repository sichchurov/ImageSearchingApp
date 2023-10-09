package com.shchurovsi.imagesearchingapp.data.network.api

import com.shchurovsi.imagesearchingapp.data.network.models.ListImageDto
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(
    private val apiService: ApiService
) : ApiHelper {
    override suspend fun searchPhotos(query: String, page: Int, perPage: Int): ListImageDto {
        return apiService.searchPhotos(query, page, perPage)
    }

}
