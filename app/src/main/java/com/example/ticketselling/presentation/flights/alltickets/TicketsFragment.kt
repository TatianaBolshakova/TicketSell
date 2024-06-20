package com.example.ticketselling.presentation.flights.alltickets

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.ticketselling.R
import com.example.ticketselling.adapter.TicketsAdapter
import com.example.ticketselling.databinding.FragmentTicketsBinding
import com.example.ticketselling.presentation.constants.Constants
import com.example.ticketselling.presentation.flights.search.SearchViewModel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.viewmodel.ext.android.viewModel


class TicketsFragment : Fragment() {

    private var _binding: FragmentTicketsBinding? = null
    private val binding get() = _binding!!

    private var searchResultFrom = ""
    private var searchResultTo = ""
    private var dateTickets = ""

    private val viewModel by viewModel<TicketsViewModel>()
    private val ticketsAdapter = TicketsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            searchResultFrom = it.getString(Constants.KEY_SEARCH_FROM).toString()
            searchResultTo = it.getString(Constants.KEY_SEARCH_TO).toString()
            dateTickets = it.getString(Constants.KEY_DATE).toString()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTicketsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            townFrom.text = searchResultFrom
            townTo.text = searchResultTo
            date.text = dateTickets
        }

        viewModel.loadTickets()
        binding.ticketsRecycler.adapter = ticketsAdapter
        viewModel.tickets.onEach { ticketsAdapter.setData(it) }
            .launchIn(viewLifecycleOwner.lifecycleScope)

        binding.back.setOnClickListener {
            findNavController().navigate(R.id.countrySelectedFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}