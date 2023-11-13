package com.shchurovsi.imagesearchingapp.presentation.gallery

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.shchurovsi.imagesearchingapp.domain.usecases.SearchPhotoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GalleryViewModel @Inject constructor(
    private val searchPhotoUseCase: SearchPhotoUseCase
) : ViewModel() {

    private val currentQuery = MutableLiveData(DEFAULT_QUERY)

    val images = currentQuery.switchMap {
        searchPhotoUseCase(query = it)
    }

    fun searchPhotos(query: String) {
        currentQuery.value = query
    }

    companion object {
        private const val DEFAULT_QUERY = "cats"
    }

}