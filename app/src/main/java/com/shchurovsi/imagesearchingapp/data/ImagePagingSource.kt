package com.shchurovsi.imagesearchingapp.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.shchurovsi.imagesearchingapp.data.network.api.ApiHelperImpl
import com.shchurovsi.imagesearchingapp.data.network.models.ImageDto
import com.shchurovsi.imagesearchingapp.data.network.models.ListImageDto
import retrofit2.HttpException
import java.io.IOException

private const val STARTING_KEY = 1

class ImagePagingSource(
    private val api: ApiHelperImpl,
    private val query: String
) : PagingSource<Int, ImageDto>() {
    override fun getRefreshKey(state: PagingState<Int, ImageDto>): Int? {
        TODO("Not yet implemented")
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ImageDto> {
        val start = params.key ?: STARTING_KEY

        return try {
            val response = api.searchPhotos(
                query = query,
                page = start,
                perPage = params.loadSize
            )

            val images = response.images

            LoadResult.Page(
                data = images,
                prevKey = if (start == STARTING_KEY) null else start - 1,
                nextKey = if (images.isEmpty()) null else start + 1
            )
        } catch (e: IOException) {
            LoadResult.Error(e)
        } catch (e: HttpException) {
            LoadResult.Error(e)
        }
    }


}
