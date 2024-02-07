package com.example.horizontalscrollapp_exm8.presentation.state

import com.example.horizontalscrollapp_exm8.domain.model.Item


data class ItemsState(
    val isLoading: Boolean = false,
    val data: List<Item>? = null,
    val errorMessage: String? = null
)