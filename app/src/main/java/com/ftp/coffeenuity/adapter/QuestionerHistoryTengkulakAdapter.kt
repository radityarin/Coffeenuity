package com.ftp.coffeenuity.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ftp.coffeenuity.databinding.ItemQuestionerHistoryBinding
import com.ftp.coffeenuity.domain.model.QuestionerPetani
import com.ftp.coffeenuity.domain.model.QuestionerTengkulak

class QuestionerHistoryTengkulakAdapter :
    RecyclerView.Adapter<QuestionerHistoryTengkulakAdapter.OnBoardingViewHolder>() {

    private val items = mutableListOf<QuestionerTengkulak?>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return OnBoardingViewHolder(
            ItemQuestionerHistoryBinding.inflate(
                layoutInflater,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        val model = items[position]
        if (model != null) {
            holder.bind(model)
        }
    }

    override fun getItemCount() = items.size

    fun submitList(data: List<QuestionerTengkulak?>) {
        items.clear()
        items.addAll(data)
        notifyDataSetChanged()
    }

    inner class OnBoardingViewHolder(private val binding: ItemQuestionerHistoryBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(model: QuestionerTengkulak) {
            with(binding) {
                tvDate.text = model.date
                tvKategoriEkonomi.text = model.ahpResponse.indeksBerkelanjutan.ekonomi.kategori
                tvKategoriSosial.text = model.ahpResponse.indeksBerkelanjutan.sosial.kategori
                tvKategoriLingkungan.text = model.ahpResponse.indeksBerkelanjutan.lingkungan.kategori
            }
        }

    }


}