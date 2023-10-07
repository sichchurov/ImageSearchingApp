package com.shchurovsi.imagesearchingapp.data.network.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class LinksDto(
    val download: String,
    val html: String,
    val self: String
) : Parcelable