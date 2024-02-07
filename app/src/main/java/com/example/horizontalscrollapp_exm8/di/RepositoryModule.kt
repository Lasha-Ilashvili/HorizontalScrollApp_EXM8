package com.example.horizontalscrollapp_exm8.di

import com.example.horizontalscrollapp_exm8.data.common.HandleResponse
import com.example.horizontalscrollapp_exm8.data.repository.ItemsRepositoryImpl
import com.example.horizontalscrollapp_exm8.data.service.ItemsService
import com.example.horizontalscrollapp_exm8.domain.repository.ItemsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideItemsRepository(
        itemsService: ItemsService,
        handleResponse: HandleResponse
    ): ItemsRepository {
        return ItemsRepositoryImpl(
            itemsService = itemsService,
            handleResponse = handleResponse
        )
    }
}