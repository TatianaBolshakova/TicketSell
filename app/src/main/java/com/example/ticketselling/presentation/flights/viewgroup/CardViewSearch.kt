package com.example.ticketselling.presentation.flights.viewgroup

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import androidx.appcompat.widget.SearchView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.findNavController
import com.example.ticketselling.R
import com.example.ticketselling.databinding.CardViewSearchBinding
import com.example.ticketselling.presentation.constants.Constants
import com.example.ticketselling.presentation.constants.Constants.KEY_SEARCH_FROM
import com.example.ticketselling.presentation.sharedpreferens.SharedPrefs.prefFrom
import com.example.ticketselling.presentation.sharedpreferens.SharedPrefs.prefTo

class CardViewSearch @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : ConstraintLayout(context, attrs) {
    private var binding: CardViewSearchBinding

    init {
        val inflatedView = inflate(context, R.layout.card_view_search, this)
        binding = CardViewSearchBinding.bind(inflatedView)
    }

    fun setSearchQuery(searchResultFrom: String) {
        binding.searchFrom.apply {
            onActionViewExpanded()
            setQuery(searchResultFrom, true)
            clearFocus()
            if (query.isBlank()) {
                queryHint = "Откуда - Москва"
            }
        }
    }


    fun setSearchTo(town: String) {
        binding.searchTo.apply {
            onActionViewExpanded()
            setQuery(town, true)
            clearFocus()
        }
    }

    fun getQueryTo(): String {
        return binding.searchTo.query.toString()
    }

    var searchFromLastValue =
        prefFrom?.getString(KEY_SEARCH_FROM, Constants.DEF_SEARCH_FROM).toString()

    fun searchFromListener() {
        binding.searchFrom.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(keyword: String?): Boolean {
                if (keyword?.isNotEmpty() == true) {
                    saveSearchFrom(keyword.toString())
                    searchFromLastValue = keyword.toString()
                }
                return true
            }
        })
    }

    fun searchToListener() {
        binding.searchTo.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }
            override fun onQueryTextChange(keyword: String?): Boolean {
                if (keyword?.isNotEmpty() == true) {
                    saveSearchTo(keyword.toString())
                }
                return true
            }
        })
    }

    fun searchToListenerFocus(searchResultFrom: String) {

        binding.searchTo.setOnQueryTextFocusChangeListener { v, hasFocus ->
            if (hasFocus()) {
                if (searchFromLastValue.isNotEmpty()) {
                    searchToFocus(searchFromLastValue)
                } else {
                    searchToFocus(searchResultFrom)
                }
            }
        }
    }

    private fun searchToFocus(searchResultFrom: String) {

        val bundle = Bundle().apply {
            putString(KEY_SEARCH_FROM, searchResultFrom)
        }
        findNavController().navigate(R.id.searchFragment, args = bundle)
    }

    private fun saveSearchFrom(word: String) {
        val editor = prefFrom?.edit()
        editor?.putString(KEY_SEARCH_FROM, word)
        editor?.apply()
    }

    private fun saveSearchTo(word: String) {
        val editor = prefTo?.edit()
        editor?.putString(Constants.KEY_SEARCH_TO, word)
        editor?.apply()
    }
}
