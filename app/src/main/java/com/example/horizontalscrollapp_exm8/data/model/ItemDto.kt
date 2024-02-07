package com.example.horizontalscrollapp_exm8.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ItemDto(
    val id: Int,
    val cover: String,
    val price: String,
    val title: String,
    val location: String,
    @Json(name = "reaction_count")
    val reactionCount: Int,
    val rate: Int? = null
)