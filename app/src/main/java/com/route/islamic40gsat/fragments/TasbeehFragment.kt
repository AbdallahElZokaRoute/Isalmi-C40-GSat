package com.route.islamic40gsat.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.route.islamic40gsat.databinding.FragmentTasbeehBinding

class TasbeehFragment : Fragment() {

    private var counter = 0
    private val maxCounter = 30
    private var _binding: FragmentTasbeehBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentTasbeehBinding.inflate(inflater, container, false)
        val view = binding.root


        binding.tasbehClick.setOnClickListener { incrementCounter() }

        return binding.root
    }

    private fun incrementCounter() {
        counter++
        if (counter > maxCounter) {
            counter = 0
        }

        binding.tasbehCounter.text = counter.toString()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
