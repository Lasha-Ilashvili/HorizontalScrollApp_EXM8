package com.example.horizontalscrollapp_exm8.data.service

import com.example.horizontalscrollapp_exm8.data.model.ItemDto
import retrofit2.Response
import retrofit2.http.GET

interface ItemsService {
    @GET("0545ddc1-c487-46ce-b70c-5b95270d6b76")
    suspend fun getItems(): Response<List<ItemDto>>
}