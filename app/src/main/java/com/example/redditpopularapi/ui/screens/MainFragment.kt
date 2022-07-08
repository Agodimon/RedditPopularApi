package com.example.redditpopularapi.ui.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.redditpopularapi.R
import com.example.redditpopularapi.databinding.FragmentMainBinding
import org.koin.android.ext.android.getKoin
import org.koin.core.scope.Scope

class MainFragment : Fragment(R.layout.fragment_main) {

    val scope: Scope = getKoin().createScope<MainFragment>()
    private val binding: FragmentMainBinding by viewBinding()
    private val viewModel: MainViewModel = scope.get()
    private var adapter: MainAdapter? = null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        setMenuVisibility(true)
    }
}