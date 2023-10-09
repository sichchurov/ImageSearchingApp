package com.shchurovsi.imagesearchingapp.di

import com.shchurovsi.imagesearchingapp.BuildConfig
import com.shchurovsi.imagesearchingapp.data.network.api.ApiHelper
import com.shchurovsi.imagesearchingapp.data.network.api.ApiHelperImpl
import com.shchurovsi.imagesearchingapp.data.network.api.ApiService
import com.shchurovsi.imagesearchingapp.data.repository.PhotosRepositoryImpl
import com.shchurovsi.imagesearchingapp.domain.PhotosRepository
import com.shchurovsi.imagesearchingapp.others.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideBaseUrl() = Constants.BASE_URL

    @Provides
    @Singleton
    fun provideOkHttpClient() = if (BuildConfig.DEBUG) {
        val loggingInspector = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        OkHttpClient.Builder()
            .addInterceptor(loggingInspector)
            .build()
    } else {
        OkHttpClient.Builder().build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient, baseUrl: String): Retrofit =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService =
        retrofit.create(ApiService::class.java)

    @Provides
    @Singleton
    fun bindApiHelper(impl: ApiHelperImpl): ApiHelper = impl

    @Provides
    @Singleton
    fun bindPhotosRepository(impl: PhotosRepositoryImpl): PhotosRepository = impl
}
