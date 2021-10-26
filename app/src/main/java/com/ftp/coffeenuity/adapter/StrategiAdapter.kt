package com.ftp.coffeenuity.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ftp.coffeenuity.databinding.ItemStrategiBinding
import com.ftp.coffeenuity.domain.model.StrategiItem

class StrategiAdapter : RecyclerView.Adapter<StrategiAdapter.StrategiItemViewHolder>() {

    private val items = mutableListOf<StrategiItem?>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StrategiItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return StrategiItemViewHolder(ItemStrategiBinding.inflate(layoutInflater, parent, false))
    }

    override fun onBindViewHolder(holder: StrategiItemViewHolder, position: Int) {
        val model = items[position]
        if (model != null) {
            holder.bind(model)
        }
    }

    override fun getItemCount() = items.size

    fun submitList(data: List<StrategiItem?>) {
        items.clear()
        items.addAll(data)
        notifyDataSetChanged()
    }

    inner class StrategiItemViewHolder(private val binding: ItemStrategiBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(model: StrategiItem) {
            with(binding) {
                tvNo.text = "${model.no}."
                tvContent.text = model.strategi
            }
        }

    }


}