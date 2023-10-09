package com.shchurovsi.imagesearchingapp.domain.entities

data class Image(
    val id: String,
    val description: String?,
    val likes: Int,
    val urls: Urls,
    val user: User
)