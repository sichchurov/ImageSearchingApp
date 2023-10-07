package com.shchurovsi.imagesearchingapp.data.network.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProfileImageDto(
    val large: String,
    val medium: String,
    val small: String
) : Parcelable