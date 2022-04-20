package com.neomoneybonds.app.viewmodels

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.example.BasketDetailResponse
import com.neomoneybonds.app.databinding.LayoutTenureOptionBinding
import com.neomoneybonds.app.view.BindableAdapter

class TenureOptionAdapter(private val viewModel: BasketDetailsViewModel) : RecyclerView.Adapter<BasketViewHolder>(), BindableAdapter<BasketDetailResponse> {

    private val items: ArrayList<BasketDetailResponse> = arrayListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BasketViewHolder {
        val binding =
            LayoutTenureOptionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BasketViewHolder(binding,viewModel)
    }

    override fun onBindViewHolder(holder: BasketViewHolder, position: Int) {
        holder.bind(items[position])

    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun setData(list: List<BasketDetailResponse>?) {
        list?.let {
            items.clear()
            items.addAll(it)
            notifyDataSetChanged()
        }

    }

}


class BasketViewHolder(private val binding: LayoutTenureOptionBinding,val viewModel: BasketDetailsViewModel) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(data: BasketDetailResponse) {
        binding.data = data
        binding.viewModel = viewModel
    }
}
