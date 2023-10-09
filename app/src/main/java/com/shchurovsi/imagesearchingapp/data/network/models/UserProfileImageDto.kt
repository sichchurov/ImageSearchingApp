package com.shchurovsi.imagesearchingapp.data.network.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserProfileImageDto(
    val large: String,
    val medium: String,
    val small: String
) : Parcelable