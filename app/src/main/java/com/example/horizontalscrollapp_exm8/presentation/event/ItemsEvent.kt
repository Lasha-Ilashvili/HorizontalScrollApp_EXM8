package com.example.horizontalscrollapp_exm8.presentation.event

sealed class ItemsEvent {
    data object ResetErrorMessage : ItemsEvent()
}