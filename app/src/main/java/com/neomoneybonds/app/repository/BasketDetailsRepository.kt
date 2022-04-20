package com.neomoneybonds.app.repository

import com.example.example.Result
import com.neomoneybonds.app.api.ApiServiceImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import javax.inject.Inject


class BasketDetailsRepository @Inject constructor(private val apiServiceImpl: ApiServiceImpl) {

    init {


    }

    fun getBasketDetails(): Flow<Result> = flow {
        val response = apiServiceImpl.getBasketDetailsItem()
        emit(response.data?.result)
    }.filterNotNull()
        .flowOn(Dispatchers.IO)
        .conflate()



  //  fun getBasketDetails2(): Flow<Result> = flow {
   //     val response = apiServiceImpl.getBasketDetailsItem()
  //      emit(response.data?.result)
   // }.filterNotNull()
     //   .flowOn(Dispatchers.IO)
    //    .conflate()


 //   fun getBasketDetails3(): Flow<Pair<Result,Result>> = flow<Pair<Result,Result>> {
  //
    //    getBasketDetails().combine(getBasketDetails2()){ a: Result, b: Result ->
   //       flowOf(Pair(a,b)) }
  //    }.flowOn(Dispatchers.IO).conflate()



    //suspend fun show(){
      //  getBasketDetails3().collect{
        //    it.first
        //    it.second
        }




