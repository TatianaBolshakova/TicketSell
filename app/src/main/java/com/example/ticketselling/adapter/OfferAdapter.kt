package com.example.ticketselling.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.models.ItemsTips
import com.example.ticketselling.R
import com.example.ticketselling.databinding.OfferItemBinding
import com.example.ticketselling.viewholder.OfferViewHolder


class OfferAdapter(

) : RecyclerView.Adapter<OfferViewHolder>() {

    private var data: List<ItemsTips?> = emptyList()

    fun setData(data: List<ItemsTips>) {
        this.data = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OfferViewHolder {
        return OfferViewHolder(
            OfferItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

   private val images = listOf(
        R.drawable.die_antwoord,
        R.drawable.socrat_lera,
        R.drawable.lanpabikt
    )

    override fun onBindViewHolder(holder: OfferViewHolder, position: Int) {
        val item = data.getOrNull(position)
        with(holder.binding) {
            titleText.text = item?.title ?: "Title"
            townText.text = item?.town ?: "Town"
            priceText.text = item?.priceDomain?.value.toString()
            imageView.setImageResource(images[position])
            imageView.isClickable = false
        }
    }

    override fun getItemCount(): Int = data.size
}

