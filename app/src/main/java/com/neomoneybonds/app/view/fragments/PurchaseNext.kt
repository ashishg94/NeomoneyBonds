package com.neomoneybonds.app.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.neomoneybonds.app.databinding.FragmentPurchaseNextBinding
import com.neomoneybonds.app.viewmodels.BasketDetailsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PurchaseNextFragment : Fragment() {

    companion object {
        fun newInstance() = PurchaseNextFragment()
    }

    private lateinit var binding: FragmentPurchaseNextBinding
    private val basketDetailsViewModel: BasketDetailsViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPurchaseNextBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = this
        binding.viewModel = basketDetailsViewModel
    }

}

