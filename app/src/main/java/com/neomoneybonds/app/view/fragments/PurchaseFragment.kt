package com.neomoneybonds.app.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.neomoneybonds.app.databinding.FragmentPurchaseDetailsBinding
import com.neomoneybonds.app.viewmodels.BasketDetailsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PurchaseDetailsFragment : Fragment() {

    companion object {
        fun newInstance() = PurchaseDetailsFragment()
    }

    private lateinit var binding: FragmentPurchaseDetailsBinding
    private val basketDetailsViewModel: BasketDetailsViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPurchaseDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = this
        binding.viewModel = basketDetailsViewModel


    }

}

