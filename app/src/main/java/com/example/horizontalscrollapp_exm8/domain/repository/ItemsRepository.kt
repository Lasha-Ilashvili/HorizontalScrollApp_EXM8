package com.example.horizontalscrollapp_exm8.domain.repository

import com.example.horizontalscrollapp_exm8.data.common.Resource
import com.example.horizontalscrollapp_exm8.domain.model.Item
import kotlinx.coroutines.flow.Flow

interface ItemsRepository {
    suspend fun getItems(): Flow<Resource<List<Item>>>
}