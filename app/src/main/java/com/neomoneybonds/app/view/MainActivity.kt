package com.neomoneybonds.app.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.commit
import com.neomoneybonds.app.R
import com.neomoneybonds.app.databinding.ActivityMainBinding
import com.neomoneybonds.app.view.fragments.BaseketDetailFragment
import com.neomoneybonds.app.view.fragments.PurchaseDetailsFragment
import com.neomoneybonds.app.view.fragments.PurchaseNextFragment
import com.neomoneybonds.app.view.fragments.SafetyGrowthFragment
import com.neomoneybonds.app.viewmodels.BasketDetailsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val basketDetailsViewModel: BasketDetailsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (savedInstanceState == null) {
            setSafetyGrowthFragment()
        }
        basketDetailsViewModel.showGrowthBasket.observe(this) {
            if (it) {
                showGrowthBasket()
            }
        }

        basketDetailsViewModel.showPurchase.observe(this) {
            if (it) {
                showPurchase()
            }
        }
        basketDetailsViewModel.showPurchaseNext.observe(this) {
            if (it) {
                showPurchaseNext()
            }
        }
    }



    private fun showGrowthBasket() {
        supportFragmentManager.commit {
            replace(R.id.container, BaseketDetailFragment.newInstance())
            setReorderingAllowed(true)
            addToBackStack(null)
        }
    }
    private fun showPurchase() {
        supportFragmentManager.commit {
            replace(R.id.container, PurchaseDetailsFragment.newInstance())
            setReorderingAllowed(true)
            addToBackStack(null)
        }
    }
    private fun showPurchaseNext() {
        supportFragmentManager.commit {
            replace(R.id.container, PurchaseNextFragment.newInstance())
            setReorderingAllowed(true)
            addToBackStack(null)
        }
    }

    private fun setSafetyGrowthFragment() {
        supportFragmentManager.commit {
            replace( R.id.container, SafetyGrowthFragment.newInstance())
            setReorderingAllowed(true)
        }
    }

   // override fun onBackPressed() {
   //     super.onBackPressed()
    }
