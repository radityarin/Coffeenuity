package com.ftp.coffeenuity.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ftp.coffeenuity.databinding.ItemQuestionerHistoryBinding
import com.ftp.coffeenuity.domain.model.QuestionerPetani

class QuestionerHistoryPetaniAdapter :
    RecyclerView.Adapter<QuestionerHistoryPetaniAdapter.OnBoardingViewHolder>() {

    private val items = mutableListOf<QuestionerPetani?>()
    private lateinit var onHistoryClickListener: OnHistoryClickListener

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

    fun setHistoryClickListener(onHistoryClickListener: OnHistoryClickListener){
        this.onHistoryClickListener = onHistoryClickListener
    }

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        val model = items[position]
        if (model != null) {
            holder.bind(model)
        }
    }

    override fun getItemCount() = items.size

    fun submitList(data: List<QuestionerPetani?>) {
        items.clear()
        items.addAll(data)
        notifyDataSetChanged()
    }

    inner class OnBoardingViewHolder(private val binding: ItemQuestionerHistoryBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(model: QuestionerPetani) {
            binding.root.setOnClickListener {
                onHistoryClickListener.onItemClickListener(model)
            }
            with(binding) {
                tvDate.text = model.date
                tvKategoriEkonomi.text = model.ahpResponse.indeksBerkelanjutan.ekonomi.kategori
                tvKategoriSosial.text = model.ahpResponse.indeksBerkelanjutan.sosial.kategori
                tvKategoriLingkungan.text = model.ahpResponse.indeksBerkelanjutan.lingkungan.kategori
            }
        }

    }

    interface OnHistoryClickListener{
        fun onItemClickListener(questionerPetani : QuestionerPetani)
    }


}