package com.example.ticketselling.presentation.briefly

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.ticketselling.databinding.FragmentBrieflyBinding


class BrieflyFragment : Fragment() {

    private var _binding: FragmentBrieflyBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val brieflyViewModel =
            ViewModelProvider(this).get(BrieflyViewModel::class.java)

        _binding = FragmentBrieflyBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textBriefly
        brieflyViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}