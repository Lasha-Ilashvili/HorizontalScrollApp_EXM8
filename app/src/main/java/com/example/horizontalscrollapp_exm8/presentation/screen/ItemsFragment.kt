package com.example.horizontalscrollapp_exm8.presentation.screen

import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.horizontalscrollapp_exm8.databinding.FragmentItemsBinding
import com.example.horizontalscrollapp_exm8.presentation.base.BaseFragment
import com.example.horizontalscrollapp_exm8.presentation.event.ItemsEvent
import com.example.horizontalscrollapp_exm8.presentation.extension.showToast
import com.example.horizontalscrollapp_exm8.presentation.state.ItemsState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class ItemsFragment : BaseFragment<FragmentItemsBinding>(FragmentItemsBinding::inflate) {

    private val viewModel: ItemsViewModel by viewModels()

    override fun bind() {

    }

    override fun bindObserves() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.items.collect {
                    handleState(it)
                }
            }
        }
//        viewLifecycleOwner.lifecycleScope.launch {
//            repeatOnLifecycle(Lifecycle.State.STARTED) {
//                viewModel.uiEvent.collect {
//                    handleNavigationEvents(event = it)
//                }
//            }
//        }
    }

    private fun handleState(storeItemsState: ItemsState) {
//        binding.progressBar.visibility =
//            if (storeItemsState.isLoading) View.VISIBLE else View.GONE

        storeItemsState.data?.let {
//            binding.rvParent.adapter = MainPageRecyclerAdapter().apply {
//                itemOnClick = ::navigateToItemPage
//                setParentData(it.categories)
//            }
        }

        storeItemsState.errorMessage?.let {
            binding.root.showToast(storeItemsState.errorMessage)
            viewModel.onEvent(ItemsEvent.ResetErrorMessage)
        }
    }

//    private fun navigateToItemPage(id: Int) {
//        findNavController().navigate(
//            MainPageFragmentDirections.actionMainPageFragmentToItemPageFragment(id = id)
//        )
//    }

//    private fun handleNavigationEvents(event: MainPageViewModel.MainPageUiEvent) {
//        when (event) {
//            is MainPageViewModel.MainPageUiEvent.NavigateBackToWelcomePage -> {
//                findNavController().navigate(
//                    MainPageFragmentDirections.actionMainPageFragmentToWelcomePageFragment()
//                )
//            }
//        }
//    }
}