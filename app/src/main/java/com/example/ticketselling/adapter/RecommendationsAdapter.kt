package com.example.ticketselling.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ticketselling.R
import com.example.ticketselling.databinding.ItemPopularsBinding

import com.example.ticketselling.viewholder.RecommendationsViewHolder


class RecommendationsAdapter(
    private val onClick: (String) -> Unit
) : RecyclerView.Adapter<RecommendationsViewHolder>() {

    private var data: List<String?> = emptyList()

    fun setData(data: List<String>) {
        this.data = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecommendationsViewHolder {
        return RecommendationsViewHolder(
            ItemPopularsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    private val images = listOf(
        R.drawable.stambul,
        R.drawable.sochi,
        R.drawable.phuket,
    )
    private val popularsText = "Популярное направление"

    override fun onBindViewHolder(holder: RecommendationsViewHolder, position: Int) {
        val item = data.getOrNull(position)
        with(holder.binding) {
            town.text = item
            populars.text = popularsText
            imageTown.setImageResource(images[position])
            imageTown.isClickable = false
        }
        holder.binding.root.setOnClickListener {
            item?.let {
                onClick(item)
            }
        }
    }

    override fun getItemCount(): Int = data.size
}

