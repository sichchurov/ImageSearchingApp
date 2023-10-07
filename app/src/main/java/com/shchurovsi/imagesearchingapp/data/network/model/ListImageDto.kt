package com.shchurovsi.imagesearchingapp.data.network.model


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class ListImageDto(
    val images: List<ImageDto>,
    val total: Int,
    @SerializedName("total_pages")
    val totalPages: Int
) : Parcelable