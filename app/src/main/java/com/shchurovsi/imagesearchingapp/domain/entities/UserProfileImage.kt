package com.shchurovsi.imagesearchingapp.domain.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserProfileImage(
    val large: String,
    val medium: String,
    val small: String
) : Parcelable