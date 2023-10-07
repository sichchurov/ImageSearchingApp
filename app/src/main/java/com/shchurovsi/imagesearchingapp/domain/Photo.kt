package com.shchurovsi.imagesearchingapp.domain


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Photo(
    val images: List<Image>,
    val total: Int,
    @SerializedName("total_pages")
    val totalPages: Int
) : Parcelable