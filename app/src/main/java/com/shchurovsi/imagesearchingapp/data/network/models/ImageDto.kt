package com.shchurovsi.imagesearchingapp.data.network.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ImageDto(
    @SerializedName("blur_hash")
    val blurHash: String,
    val color: String,
    @SerializedName("created_at")
    val createdAt: String,
    val description: String,
    val height: Int,
    val id: String,
    @SerializedName("liked_by_user")
    val likedByUser: Boolean,
    val likes: Int,
    val links: LinksDto,
    val urls: UrlsDto,
    val user: UserDto,
    val width: Int
) : Parcelable