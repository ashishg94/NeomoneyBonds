package com.neomoneybonds.app.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.example.BasketDetailResponse
import com.example.example.Result
import com.neomoneybonds.app.repository.BasketDetailsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class BasketDetailsViewModel @Inject constructor(
    private val basketDetailsRepository: BasketDetailsRepository
    ) :
    ViewModel() {

    private val _currentBasket: MutableLiveData<BasketDetailResponse> = MutableLiveData()
    val currentBasket: LiveData<BasketDetailResponse> = _currentBasket



    private val _highestSafety: MutableLiveData<BasketDetailResponse> = MutableLiveData()
    val highestSafety: LiveData<BasketDetailResponse> = _highestSafety


    private val _highestGrowth: MutableLiveData<BasketDetailResponse> = MutableLiveData()
    val highestGrowth: LiveData<BasketDetailResponse> = _highestGrowth



    private val _result: MutableLiveData<Result> = MutableLiveData()
    val result: LiveData<Result> = _result


    private val _basketDetailResponse: MutableLiveData<List<BasketDetailResponse>> = MutableLiveData()
    val basketDetailResponse: LiveData<List<BasketDetailResponse>> = _basketDetailResponse


    private val _isExpanded: MutableLiveData<Boolean> = MutableLiveData(false)
    val isExpanded: LiveData<Boolean> = _isExpanded

     val isSafetyExpanded: MutableLiveData<Boolean> = MutableLiveData(false)

     val isGrowthExpanded: MutableLiveData<Boolean> = MutableLiveData(false)
     val showGrowthBasket: MutableLiveData<Boolean> = MutableLiveData(false)
    val showPurchase: MutableLiveData<Boolean> = MutableLiveData(false)
    val showPurchaseNext: MutableLiveData<Boolean> = MutableLiveData(false)

    private val _isAddFundEnabled: MutableLiveData<Boolean> = MutableLiveData(false)
    val isAddFundEnabled: LiveData<Boolean> = _isAddFundEnabled




    private val _selectedQuantity: MutableLiveData<Int> = MutableLiveData(0)
    val selectedQuantity: LiveData<Int> = _selectedQuantity


    init {
        basketDetailsRepository.getBasketDetails().onEach {
            if (it.safety.isNotEmpty()) {
                it.safety[0].isSelected = true
                _currentBasket.value=it.safety[0]
            }
            _result.value = it

            var maxRate : Double= 0.0
            var basketDetailResponse:BasketDetailResponse?=null
            it.growth.forEach {
               if((it.basket?.avgCouponRate ?:0.0) > maxRate){
                   maxRate= it.basket?.avgCouponRate?:0.0
                   basketDetailResponse = it

               }
            }
            basketDetailResponse?.let {
                _highestGrowth.value = it
            }

           maxRate = 0.0
            var safetyDetailResponse:BasketDetailResponse?=null
            it.safety.forEach {
                if((it.basket?.avgCouponRate ?:0.0) > maxRate){
                    maxRate= it.basket?.avgCouponRate?:0.0
                    safetyDetailResponse = it
                }
            }

            safetyDetailResponse?.let {
                _highestSafety.value=it
            }

            _basketDetailResponse.value=it.safety
            print(it)
        }.launchIn(viewModelScope)
    }

    fun enableExpanded() {
     //  if (_basket.value?.option?.isNotEmpty() == true) {
     //       _isExpanded.value?.let {
     //          _isExpanded.value = !it
   //      }
  //     }
   }

    fun addFundEnabled() {

        _isAddFundEnabled.value?.let {
            _isAddFundEnabled.value = !it
        }

    }
fun getTenure(index:Int):Double{
    return basketDetailResponse.value?.getOrNull(index)?.basket?.getRateOfInterest()?:0.0
}



    fun expandSafety() {
        isSafetyExpanded.value=!(isSafetyExpanded.value?:false)
    }


    fun expandGrowth() {
        isGrowthExpanded.value=!(isGrowthExpanded.value?:false)
    }

    fun showGrowthBasket(boolean: Boolean) {
        showGrowthBasket.value=boolean
    }

    fun showPurchase(boolean: Boolean) {
        showPurchase.value=boolean
    }

    fun showPurchaseNext(boolean: Boolean) {
        showPurchaseNext.value=boolean
    }
    fun onSelect(data: BasketDetailResponse) {

        _basketDetailResponse.value?.onEach {
            it.isSelected = it == data
            _currentBasket.value=data

            result.value?.growth?.find { basket->
                basket.basket?.basketId == data.basket?.basketId
            }?.let {
                _highestGrowth.value = it
            }

            result.value?.safety?.find { basket->
                basket.basket?.basketId == data.basket?.basketId
            }?.let {
                _highestSafety.value = it
            }
        }
        _basketDetailResponse.value = _basketDetailResponse.value
    }

    fun increaseQuantity() {
        if (_selectedQuantity.value ?: 0 <= Int.MAX_VALUE) {
            _selectedQuantity.value = (_selectedQuantity.value ?: 0) + 1
        }
    }

    fun decreaseQuantity() {
        if (_selectedQuantity.value ?: 0 > 0) {
            _selectedQuantity.value = (_selectedQuantity.value ?: 0) - 1
        }
    }

   // fun maxValue(){
  //      _selectedQuantity*g
  //  }

}