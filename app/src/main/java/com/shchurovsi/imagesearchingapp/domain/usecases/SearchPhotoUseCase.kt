package com.shchurovsi.imagesearchingapp.domain.usecases

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import com.shchurovsi.imagesearchingapp.domain.PhotosRepository
import com.shchurovsi.imagesearchingapp.domain.entities.Image
import com.shchurovsi.imagesearchingapp.domain.entities.ListImage
import javax.inject.Inject

class SearchPhotoUseCase @Inject constructor(
    private val repository: PhotosRepository
) {

    operator fun invoke(
        query: String,
        page: Int = 1,
        perPage: Int = 10
    ): LiveData<PagingData<Image>> {
        return repository.searchPhoto(query, page, perPage)
    }
}
