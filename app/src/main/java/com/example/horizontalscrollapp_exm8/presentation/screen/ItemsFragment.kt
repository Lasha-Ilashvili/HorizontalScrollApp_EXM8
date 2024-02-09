package com.example.horizontalscrollapp_exm8.presentation.screen

import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import com.example.horizontalscrollapp_exm8.databinding.FragmentItemsBinding
import com.example.horizontalscrollapp_exm8.presentation.adapter.ItemsPagerAdapter
import com.example.horizontalscrollapp_exm8.presentation.base.BaseFragment
import com.example.horizontalscrollapp_exm8.presentation.event.ItemsEvent
import com.example.horizontalscrollapp_exm8.presentation.extension.showToast
import com.example.horizontalscrollapp_exm8.presentation.state.ItemsState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import kotlin.math.abs


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
    }

    private fun handleState(storeItemsState: ItemsState) = with(binding) {
        binding.progressBar.visibility =
            if (storeItemsState.isLoading) View.VISIBLE else View.GONE

        storeItemsState.data?.let {
            pager.adapter = ItemsPagerAdapter().apply {
                submitList(it)
            }

            pager.apply {
                offscreenPageLimit = 3

                setPageTransformer(CompositePageTransformer().apply {
                    addTransformer(MarginPageTransformer(40))

                    addTransformer { page, position ->
                        val r = 1 - abs(position)
                        page.scaleY = 0.85f + r * 0.15f
                    }
                })
            }
        }

        storeItemsState.errorMessage?.let {
            root.showToast(storeItemsState.errorMessage)
            viewModel.onEvent(ItemsEvent.ResetErrorMessage)
        }
    }
}