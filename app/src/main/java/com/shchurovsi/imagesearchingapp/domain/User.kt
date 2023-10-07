package com.shchurovsi.imagesearchingapp.domain


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class User(
    @SerializedName("first_name")
    val firstName: String,
    val id: String,
    @SerializedName("instagram_username")
    val instagramUsername: String,
    @SerializedName("last_name")
    val lastName: String,
    val name: String,
    @SerializedName("profile_image")
    val profileImage: ProfileImage,
    val username: String
) : Parcelable