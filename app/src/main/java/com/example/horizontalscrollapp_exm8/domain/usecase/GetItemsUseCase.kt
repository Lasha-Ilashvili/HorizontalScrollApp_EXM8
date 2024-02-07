package com.example.horizontalscrollapp_exm8.domain.usecase

import com.example.horizontalscrollapp_exm8.domain.repository.ItemsRepository
import javax.inject.Inject

class GetItemsUseCase @Inject constructor(
    private val itemsRepository: ItemsRepository
) {
    suspend operator fun invoke() =
        itemsRepository.getItems()
}