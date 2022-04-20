package com.neomoneybonds.app.viewmodels

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.neomoneybonds.app.databinding.LayoutBasketListItemBinding
import com.neomoneybonds.app.model.BasketBond
import com.neomoneybonds.app.view.BindableAdapter

class ViewBasketAdapter() : RecyclerView.Adapter<ListViewHolder>(), BindableAdapter<BasketBond> {

    private val item: ArrayList<BasketBond> = arrayListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = LayoutBasketListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder:ListViewHolder, position: Int) {
        holder.bind(item[position])
    }

    override fun getItemCount(): Int {
        return item.size
    }

    override fun setData(list: List<BasketBond>?) {
        list?.let {
            item.clear()
            item.addAll(it)
            notifyDataSetChanged()
        }

    }
}
    class ListViewHolder(val binding: LayoutBasketListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(option: BasketBond) {
            binding.data = option
        }
    }
