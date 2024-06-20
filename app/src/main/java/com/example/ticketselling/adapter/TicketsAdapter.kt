package com.example.ticketselling.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.models.ItemsTickets
import com.example.ticketselling.R
import com.example.ticketselling.databinding.TicketsItemBinding
import com.example.ticketselling.viewholder.TicketsViewHolder
import com.google.android.material.datepicker.SingleDateSelector
import java.text.SimpleDateFormat
import java.time.LocalTime


class TicketsAdapter(

) : RecyclerView.Adapter<TicketsViewHolder>() {

    private var data: List<ItemsTickets?> = emptyList()

    fun setData(data: List<ItemsTickets>) {
        this.data = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TicketsViewHolder {
        return TicketsViewHolder(
            TicketsItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TicketsViewHolder, position: Int) {
        val item = data.getOrNull(position)
        with(holder.binding) {

            textPrice.text = "${item?.priceDomain?.value.toString()} P"
            departureDate.text = item?.departure?.date?.takeLast(5)
            arrialDate.text = item?.arrival?.date?.takeLast(5)
            company.text = item?.departure?.airport.toString()
            companyArrival.text = item?.arrival?.airport
            if (item?.hasTransfer == false) {
                hasTransfer.visibility = View.VISIBLE
                hasTransfer.text = "/ Без пересадок"
            }
            icon.setImageResource(R.drawable.ic_red)
        }
    }

    override fun getItemCount(): Int = data.size
}

