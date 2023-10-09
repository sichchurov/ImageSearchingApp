package com.shchurovsi.imagesearchingapp.domain.usecases

import com.shchurovsi.imagesearchingapp.domain.PhotosRepository
import com.shchurovsi.imagesearchingapp.domain.entities.ListImage
import javax.inject.Inject

class SearchPhotoUseCase @Inject constructor(
    private val repository: PhotosRepository
) {

    suspend operator fun invoke(
        query: String,
        page: Int,
        perPage: Int
    ): ListImage {
        return repository.searchPhoto(query, page, perPage)
    }
}
