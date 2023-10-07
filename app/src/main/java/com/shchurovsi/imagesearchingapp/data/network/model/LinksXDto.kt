package com.shchurovsi.imagesearchingapp.data.network.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class LinksXDto(
    val html: String,
    val likes: String,
    val photos: String,
    val self: String
) : Parcelable