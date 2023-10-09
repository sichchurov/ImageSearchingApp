package com.shchurovsi.imagesearchingapp.data.network.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UrlsDto(
    val full: String,
    val raw: String,
    val regular: String,
    val small: String,
    val thumb: String
) : Parcelable