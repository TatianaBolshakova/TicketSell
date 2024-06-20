package com.example.ticketselling.presentation.flights.countryselected

import android.icu.text.SimpleDateFormat
import android.icu.util.Calendar
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.ticketselling.R
import com.example.ticketselling.adapter.TicketsOfferAdapter
import com.example.ticketselling.databinding.FragmentCountrySelectedBinding
import com.example.ticketselling.presentation.constants.Constants
import com.example.ticketselling.presentation.constants.Constants.DATE_FORMAT
import com.example.ticketselling.presentation.sharedpreferens.SharedPrefs
import com.google.android.material.datepicker.MaterialDatePicker
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.take
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.Locale


class CountrySelectedFragment : Fragment() {

    private var _binding: FragmentCountrySelectedBinding? = null
    private val binding get() = _binding!!

    private val dateFormat = SimpleDateFormat(DATE_FORMAT, Locale.US)
    private val calendar = Calendar.getInstance()

    private var searchResultFrom = ""
    private var searchResultTo = ""

    private val viewModel by viewModel<CountrySelectedViewModel>()
    private val ticketsOfferAdapter = TicketsOfferAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            searchResultFrom = it.getString(Constants.KEY_SEARCH_FROM).toString()
            searchResultTo = it.getString(Constants.KEY_SEARCH_TO).toString()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCountrySelectedBinding.inflate(inflater)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        searchResultFrom =
            SharedPrefs.prefFrom?.getString(Constants.KEY_SEARCH_FROM, Constants.DEF_SEARCH_FROM)
                .toString()
        searchResultTo =
            SharedPrefs.prefTo?.getString(Constants.KEY_SEARCH_TO, Constants.DEF_SEARCH_TO)
                .toString()

        binding.search.apply {
            setSearchQuery(searchResultFrom)
            setSearchTo(searchResultTo)
        }

        binding.chipDate.apply {
            text = dateFormat.format(calendar.time)
            setOnClickListener {
                choiceStartDate()
            }
        }

        viewModel.loadTicketsOffers()

        binding.tickets.adapter = ticketsOfferAdapter
        viewModel.ticketsOffers.onEach {
            ticketsOfferAdapter.setData(it)
        }.take(3)
            .launchIn(viewLifecycleOwner.lifecycleScope)

        binding.seeAllTickets.setOnClickListener {
            val bundle = Bundle().apply {
                putString(Constants.KEY_SEARCH_FROM, searchResultFrom)
                putString(Constants.KEY_SEARCH_TO, searchResultTo)
                putString(Constants.KEY_DATE, binding.chipDate.text.toString())
            }

            findNavController().navigate(R.id.ticketsFragment, args = bundle)
        }
        binding.back.setOnClickListener {
            findNavController().navigate(R.id.navigation_flights)

        }
    }

    private fun choiceStartDate() {
        val dateDialog = MaterialDatePicker.Builder.datePicker()
            .setTitleText(resources.getString(R.string.data_start_title_text))
            .build()
        dateDialog.show(parentFragmentManager, "Date")
        dateDialog.addOnPositiveButtonClickListener { date ->
            calendar.timeInMillis = date
            val startDate = dateFormat.format(calendar.time)
            binding.chipDate.text = startDate
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}