package com.shchurovsi.imagesearchingapp.data.mapper

import com.shchurovsi.imagesearchingapp.data.network.models.ImageDto
import com.shchurovsi.imagesearchingapp.data.network.models.ListImageDto
import com.shchurovsi.imagesearchingapp.data.network.models.UrlsDto
import com.shchurovsi.imagesearchingapp.data.network.models.UserDto
import com.shchurovsi.imagesearchingapp.domain.entities.Image
import com.shchurovsi.imagesearchingapp.domain.entities.ListImage
import com.shchurovsi.imagesearchingapp.domain.entities.Urls
import com.shchurovsi.imagesearchingapp.domain.entities.User
import javax.inject.Inject

class PhotoMapper @Inject constructor() {

    private fun mapUserDtoToUserEntity(userDto: UserDto) = User(
        id = userDto.id,
        name = userDto.name,
        username = userDto.username
    )

    private fun mapUrlsDtoToUrlsEntity(urlsDto: UrlsDto) = Urls(
        full = urlsDto.full,
        regular = urlsDto.regular,
        small = urlsDto.small,
        thumb = urlsDto.thumb
    )

    fun mapImageDtoToImageEntity(imageDto: ImageDto) = Image(
        id = imageDto.id,
        description = imageDto.description,
        likes = imageDto.likes,
        urls = mapUrlsDtoToUrlsEntity(imageDto.urls),
        user = mapUserDtoToUserEntity(imageDto.user)
    )

    fun mapListImageToListImageDto(listImageDto: ListImageDto) = ListImage(
        listImageDto.images.map {
            mapImageDtoToImageEntity(it)
        }
    )
}
