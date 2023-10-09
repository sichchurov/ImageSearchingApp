package com.shchurovsi.imagesearchingapp.data.network.models

data class ImageDto(
    val id: String,
    val description: String?,
    val likes: Int,
    val urls: UrlsDto,
    val user: UserDto
)