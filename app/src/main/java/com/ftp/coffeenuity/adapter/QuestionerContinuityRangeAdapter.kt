package com.ftp.coffeenuity.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ftp.coffeenuity.databinding.ItemQuestionerContinuityRangeBinding
import com.ftp.coffeenuity.domain.model.QuestionerRange

class QuestionerContinuityRangeAdapter :
    RecyclerView.Adapter<QuestionerContinuityRangeAdapter.OnBoardingViewHolder>() {

    private val items = mutableListOf<QuestionerRange>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return OnBoardingViewHolder(
            ItemQuestionerContinuityRangeBinding.inflate(
                layoutInflater,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        val model = items[position]
        if (model != null) {
            holder.bind(model, position)
        }
    }

    override fun getItemCount() = items.size

    fun submitList(data: List<QuestionerRange>) {
        items.clear()
        items.addAll(data)
        notifyDataSetChanged()
    }

    fun getData(): List<QuestionerRange> {
        return items
    }

    inner class OnBoardingViewHolder(private val binding: ItemQuestionerContinuityRangeBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(model: QuestionerRange, position: Int) {
            with(binding) {
                leftTitle.text = model.leftTitle
                items[position].range = 1
                radioGroup.setOnCheckedChangeListener { _, _ ->
                    val range = radioGroup.checkedRadioButtonId % 5
                    items[position].range = range
                }
            }
        }
    }

}