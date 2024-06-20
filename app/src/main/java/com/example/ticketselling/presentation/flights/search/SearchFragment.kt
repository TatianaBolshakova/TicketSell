package com.example.ticketselling.presentation.flights.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.ticketselling.R
import com.example.ticketselling.adapter.RecommendationsAdapter
import com.example.ticketselling.adapter.TipsAdapter
import com.example.ticketselling.databinding.FragmentSearchBinding
import com.example.ticketselling.presentation.constants.Constants
import com.example.ticketselling.presentation.constants.Constants.KEY_SEARCH_FROM
import com.example.ticketselling.presentation.constants.Constants.KEY_SEARCH_TO
import com.example.ticketselling.presentation.constants.Constants.TIPS_TEXT
import com.example.ticketselling.presentation.sharedpreferens.SharedPrefs
import org.koin.androidx.viewmodel.ext.android.viewModel


class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    private var searchResultFrom = ""
    private var searchResultTo = ""

    private val viewModel by viewModel<SearchViewModel>()
    private val tipsAdapter = TipsAdapter { itemsTips -> onItemClickTips(itemsTips) }
    private val recommendationsAdapter = RecommendationsAdapter{ item-> onItemClickRecommendations(item)}


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            searchResultFrom = it.getString(KEY_SEARCH_FROM).toString()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        searchResultFrom =
            SharedPrefs.prefFrom?.getString(KEY_SEARCH_FROM, Constants.DEF_SEARCH_FROM).toString()
        searchResultTo =
            SharedPrefs.prefTo?.getString(KEY_SEARCH_TO, Constants.DEF_SEARCH_TO).toString()

        binding.apply {
            tips.adapter = tipsAdapter
            tipsAdapter.setData(viewModel.titlesTips)

            recommendations.adapter = recommendationsAdapter
            recommendationsAdapter.setData(viewModel.titlesPopulars)

            binding.search.apply {
                setSearchQuery(searchResultFrom)
                searchFromListener()
                searchToListener()
            }

            next.setOnClickListener {
                val bundle = Bundle().apply {
                    putString(KEY_SEARCH_FROM, searchResultFrom)
                    putString(KEY_SEARCH_TO, binding.search.getQueryTo())
                }
                findNavController().navigate(R.id.countrySelectedFragment, args = bundle)
            }
            back.setOnClickListener {
                findNavController().navigate(R.id.navigation_flights)
            }
        }
    }

    private fun onItemClickTips(item: String) {

        val bundle = Bundle().apply {
            putString(TIPS_TEXT, item)
        }
        findNavController().navigate(R.id.tipsFragment, args = bundle)
    }

    private fun onItemClickRecommendations(item: String) {
        binding.search.setSearchTo(item)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}