package com.shchurovsi.imagesearchingapp.data.network.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserDto(
    @SerializedName("first_name")
    val firstName: String,
    val id: String,
    @SerializedName("instagram_username")
    val instagramUsername: String,
    @SerializedName("last_name")
    val lastName: String,
    val links: LinksXDto,
    val name: String,
    @SerializedName("portfolio_url")
    val portfolioUrl: String,
    @SerializedName("profile_image")
    val profileImage: UserProfileImageDto,
    @SerializedName("twitter_username")
    val twitterUsername: String,
    val username: String
) : Parcelable