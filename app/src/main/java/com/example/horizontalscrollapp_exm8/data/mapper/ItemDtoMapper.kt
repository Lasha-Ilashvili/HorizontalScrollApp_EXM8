package com.example.horizontalscrollapp_exm8.data.mapper

import com.example.horizontalscrollapp_exm8.data.model.ItemDto
import com.example.horizontalscrollapp_exm8.domain.model.Item

fun ItemDto.toDomain(): Item {
    return Item(
        id = id,
        cover = cover,
        price = price,
        title = title,
        location = location,
        reactionCount = reactionCount,
        rate = rate
    )
}