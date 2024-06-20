package com.example.ticketselling.presentation.flights.main

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.ticketselling.adapter.OfferAdapter
import com.example.ticketselling.databinding.FragmentFlightsBinding
import com.example.ticketselling.presentation.constants.Constants.DEF_SEARCH_FROM
import com.example.ticketselling.presentation.constants.Constants.DEF_SEARCH_TO
import com.example.ticketselling.presentation.constants.Constants.KEY_SEARCH_FROM
import com.example.ticketselling.presentation.constants.Constants.KEY_SEARCH_TO
import com.example.ticketselling.presentation.constants.Constants.PREF_SEARCH_FROM
import com.example.ticketselling.presentation.constants.Constants.PREF_SEARCH_TO
import com.example.ticketselling.presentation.sharedpreferens.SharedPrefs.prefFrom
import com.example.ticketselling.presentation.sharedpreferens.SharedPrefs.prefTo
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainFragment : Fragment() {

    private var _binding: FragmentFlightsBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModel<MainViewModel>()
    private val offerAdapter = OfferAdapter()

    private var searchResultFrom = ""
    private var searchResultTo = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFlightsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        prefFrom =
            this.activity?.getSharedPreferences(PREF_SEARCH_FROM, Context.MODE_PRIVATE)
        searchResultFrom =
            prefFrom?.getString(KEY_SEARCH_FROM, DEF_SEARCH_FROM).toString()

        prefTo = this.activity?.getSharedPreferences(PREF_SEARCH_TO, Context.MODE_PRIVATE)
        searchResultTo =
            prefTo?.getString(KEY_SEARCH_TO, DEF_SEARCH_TO).toString()

        binding.search.apply {
            setSearchQuery(searchResultFrom)
            searchFromListener()
            searchToListenerFocus(searchResultFrom)
        }

        viewModel.loadOffers()
        binding.recycle.adapter = offerAdapter
        viewModel.offers.onEach {
            offerAdapter.setData(it)
        }
            .launchIn(viewLifecycleOwner.lifecycleScope)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}