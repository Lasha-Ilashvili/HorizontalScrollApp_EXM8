package com.example.horizontalscrollapp_exm8.presentation.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.horizontalscrollapp_exm8.data.common.Resource
import com.example.horizontalscrollapp_exm8.domain.usecase.GetItemsUseCase
import com.example.horizontalscrollapp_exm8.presentation.event.ItemsEvent
import com.example.horizontalscrollapp_exm8.presentation.state.ItemsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ItemsViewModel @Inject constructor(
    private val itemsUseCase: GetItemsUseCase
) : ViewModel() {

    private val _items = MutableStateFlow(ItemsState())
    val items get() = _items.asStateFlow()

//    private val _uiEvent = MutableSharedFlow<MainPageUiEvent>()
//    val uiEvent: SharedFlow<MainPageUiEvent> get() = _uiEvent

    init {
        setInitialList()
    }

    fun onEvent(event: ItemsEvent) {
        when (event) {
            is ItemsEvent.ResetErrorMessage -> updateErrorMessage()
        }
    }

    private fun setInitialList() {
        viewModelScope.launch {
            itemsUseCase().collect {
                when (it) {
                    is Resource.Success -> {
                        _items.update { currentState ->
                            currentState.copy(data = it.data)
                        }
                    }

                    is Resource.Error -> updateErrorMessage(message = it.errorMessage)

                    is Resource.Loading -> _items.update { currentState ->
                        currentState.copy(isLoading = it.loading)
                    }
                }
            }
        }
    }


    private fun updateErrorMessage(message: String? = null) {
        _items.update { currentState ->
            currentState.copy(errorMessage = message)
        }
    }

//    sealed interface MainPageUiEvent {
//        data object NavigateBackToWelcomePage : MainPageUiEvent
//    }
}