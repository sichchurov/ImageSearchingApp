package com.shchurovsi.imagesearchingapp.domain.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Image(
    val id: String,
    val description: String?,
    val likes: Int,
    val urls: Urls,
    val user: User
) : Parcelable