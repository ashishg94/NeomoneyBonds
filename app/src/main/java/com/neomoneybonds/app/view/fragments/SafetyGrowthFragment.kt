package com.neomoneybonds.app.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.neomoneybonds.app.databinding.FragmentBasketDetailsBinding
import com.neomoneybonds.app.databinding.FragmentSafetyGrowthBinding
import com.neomoneybonds.app.viewmodels.BasketDetailsViewModel
import com.neomoneybonds.app.viewmodels.TenureOptionAdapter
import com.neomoneybonds.app.viewmodels.ViewBasketAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SafetyGrowthFragment : Fragment() {

    companion object {
        fun newInstance() = SafetyGrowthFragment()
    }

    private lateinit var binding: FragmentSafetyGrowthBinding
    private val basketDetailsViewModel: BasketDetailsViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSafetyGrowthBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = this
        binding.viewModel = basketDetailsViewModel
        binding.safetyTenureList.adapter = TenureOptionAdapter(basketDetailsViewModel)
        binding.growthTenureList.adapter=TenureOptionAdapter(basketDetailsViewModel)
        binding.yes.setOnClickListener {
           basketDetailsViewModel.showGrowthBasket.value = true
        }


//        binding.layoutBasket.list.addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL))
//        binding.layoutBasket.list.adapter= ViewBasketAdapter()

    }

}

