package com.neomoneybonds.app.viewmodels

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.neomoneybonds.app.view.BindableAdapter

@BindingAdapter("data")
fun <T> bindRecyclerViewData(recyclerView: RecyclerView, list: List<T>?) {
     val adapter = recyclerView.adapter
    if(adapter is BindableAdapter<*>?){
        adapter?.setData(list as? List<Nothing>?)
    }

}
