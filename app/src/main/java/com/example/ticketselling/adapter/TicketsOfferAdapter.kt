package com.example.ticketselling.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.models.ItemsTicketsOffers
import com.example.ticketselling.R
import com.example.ticketselling.databinding.TicketsOffersItemBinding
import com.example.ticketselling.viewholder.TicketsOffersViewHolder


class TicketsOfferAdapter(
) : RecyclerView.Adapter<TicketsOffersViewHolder>() {

    private var data: List<ItemsTicketsOffers?> = emptyList()

    fun setData(data: List<ItemsTicketsOffers>) {
        this.data = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TicketsOffersViewHolder {
        return TicketsOffersViewHolder(
            TicketsOffersItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    private val images = listOf(
        R.drawable.ic_red,
        R.drawable.ic_blue,
        R.drawable.ic_white,
    )

    override fun onBindViewHolder(holder: TicketsOffersViewHolder, position: Int) {
        val item = data.getOrNull(position)
        with(holder.binding) {
            company.text = item?.title?:"Company"
            price.text = item?.price?.value.toString()
            times.text = item?.timeRange?.joinToString{time -> time}
            icon.setImageResource(images[position])

        }
    }

    override fun getItemCount(): Int = data.size
}

