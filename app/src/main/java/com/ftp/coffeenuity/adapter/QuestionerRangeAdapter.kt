package com.ftp.coffeenuity.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.recyclerview.widget.RecyclerView
import com.ftp.coffeenuity.databinding.ItemQuestionerRangeBinding
import com.ftp.coffeenuity.domain.model.QuestionerRange

class QuestionerRangeAdapter : RecyclerView.Adapter<QuestionerRangeAdapter.OnBoardingViewHolder>() {

    private val items = mutableListOf<QuestionerRange?>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return OnBoardingViewHolder(ItemQuestionerRangeBinding.inflate(layoutInflater, parent, false))
    }

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        val model = items[position]
        if (model != null) {
            holder.bind(model,position)
        }
    }

    override fun getItemCount() = items.size

    fun submitList(data: List<QuestionerRange?>) {
        items.clear()
        items.addAll(data)
        notifyDataSetChanged()
    }

    fun getData(): List<QuestionerRange?> {
        return items
    }

    inner class OnBoardingViewHolder(private val binding: ItemQuestionerRangeBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(model: QuestionerRange, position: Int) {
            with(binding) {
                leftTitle.text = model.leftTitle
                rightTitle.text = model.rightTitle
                items[position]?.range = 1
                radioGroup.setOnCheckedChangeListener { _, _ ->
                    val checkedRadioButtonId = radioGroup.checkedRadioButtonId
                    val rb = itemView.findViewById<RadioButton>(checkedRadioButtonId)
                    val range = rb.text.toString().toInt()
                    items[position]?.range = range
                }
            }
        }

    }


}