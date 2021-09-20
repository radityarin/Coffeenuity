package com.ftp.coffeenuity.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
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
                    val range = when (radioGroup.checkedRadioButtonId % 9){
                        1->9
                        2->7
                        3->5
                        4->3
                        5->1
                        6->-3
                        7->-5
                        8->-7
                        9->-9
                        else -> -1
                    }
                    items[position]?.range = range
                }
            }
        }

    }


}