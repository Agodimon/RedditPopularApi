package com.android.lookerpopularapi.ui.screens.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.android.redditpopularapi.R
import com.android.lookerpopularapi.data.models.popularItemModels.PopularItemRedditModel
import com.android.lookerpopularapi.data.source.AppState
import com.android.redditpopularapi.databinding.FragmentMainBinding
import org.koin.android.ext.android.getKoin
import org.koin.core.scope.Scope

class MainFragment : Fragment(R.layout.fragment_main) {

    val scope: Scope = getKoin().createScope<MainFragment>()
    private val binding: FragmentMainBinding by viewBinding()
    private val viewModel: MainViewModel = scope.get()
    private var adapter: MainAdapter? = null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupMenu()
        setupOnView()

    }

    private fun setupMenu() {
        setHasOptionsMenu(true)
        setMenuVisibility(true)
    }

    private fun setupOnView() {
        viewLifecycleOwner
            .lifecycleScope
            .launchWhenCreated {
                viewModel.getMore().collect {

                    adapter = MainAdapter()
                    binding.rvMain.adapter = adapter
                    adapter?.submitData(it)
                    renderData(it as AppState)
                }
            }
    }

   private fun renderData(appState: AppState) {
        when (appState) {
            is AppState.Success -> {
                adapter = MainAdapter()
                binding.rvMain.adapter = adapter
                if (appState.data is PopularItemRedditModel) {
                    adapter = MainAdapter()
                    binding.rvMain.adapter = adapter
                }
            }
        }
    }
}