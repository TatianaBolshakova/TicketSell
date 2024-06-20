package com.example.ticketselling.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ticketselling.R
import com.example.ticketselling.databinding.TipsItemBinding
import com.example.ticketselling.viewholder.TipsViewHolder


class TipsAdapter(
    private val onClick: (String) -> Unit
) : RecyclerView.Adapter<TipsViewHolder>() {

    private var data: List<String?> = emptyList()

    fun setData(data: List<String>) {
        this.data = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TipsViewHolder {
        return TipsViewHolder(
            TipsItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    private val images = listOf(
        R.drawable.difficult_route,
        R.drawable.anywhere,
        R.drawable.weekend,
        R.drawable.hot_tickets,
    )


    override fun onBindViewHolder(holder: TipsViewHolder, position: Int) {
        val item = data.getOrNull(position)
        with(holder.binding) {
            titleText.text = item
            imageView.setImageResource(images[position])
            imageView.isClickable= false
        }
        holder.binding.root.setOnClickListener {
            item?.let {
                onClick(item)
            }
        }
    }

    override fun getItemCount(): Int = data.size
}

