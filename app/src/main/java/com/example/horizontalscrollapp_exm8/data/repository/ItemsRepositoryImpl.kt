package com.example.horizontalscrollapp_exm8.data.repository

import com.example.horizontalscrollapp_exm8.data.common.HandleResponse
import com.example.horizontalscrollapp_exm8.data.common.Resource
import com.example.horizontalscrollapp_exm8.data.mapper.base.asResource
import com.example.horizontalscrollapp_exm8.data.mapper.toDomain
import com.example.horizontalscrollapp_exm8.data.service.ItemsService
import com.example.horizontalscrollapp_exm8.domain.model.Item
import com.example.horizontalscrollapp_exm8.domain.repository.ItemsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ItemsRepositoryImpl @Inject constructor(
    private val itemsService: ItemsService,
    private val handleResponse: HandleResponse,
) : ItemsRepository {

    override suspend fun getItems(): Flow<Resource<List<Item>>> {
        return handleResponse.safeApiCall {
            itemsService.getItems()
        }.asResource {
            it.map { dto ->
                dto.toDomain()
            }
        }
    }
}
