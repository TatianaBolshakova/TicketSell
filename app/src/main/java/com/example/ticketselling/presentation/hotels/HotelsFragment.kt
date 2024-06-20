package com.example.ticketselling.presentation.hotels

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.ticketselling.databinding.FragmentHotelsBinding


class HotelsFragment : Fragment() {

    private var _binding: FragmentHotelsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val hotelsViewModel =
            ViewModelProvider(this).get(HotelsViewModel::class.java)

        _binding = FragmentHotelsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHotels
        hotelsViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}