package com.route.islamic40gsat.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.route.islamic40gsat.R
import com.route.islamic40gsat.databinding.FragmentTasbeehBinding

class TasbeehFragment : Fragment() {

    var counter = 0

    var currentIndex = 0

    lateinit var azkarList: MutableList<String>

    lateinit var binding: FragmentTasbeehBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTasbeehBinding.inflate(layoutInflater, container, false)
        return binding.root
//        return inflater.inflate(R.layout.fragment_tasbeeh, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        azkarList = resources.getStringArray(R.array.azkarList).toMutableList()
        binding.textDikhr.text = azkarList[0]
        onClickSebha()

    }

    private fun onClickSebha() {
        binding.bodyOfSeb7a.setOnClickListener {
            binding.bodyOfSeb7a.rotation = (360 / 33).toFloat()
            if (counter < 33) {
                counter++
            } else {
                counter = 0
                currentIndex = if (currentIndex < azkarList.size - 1) ++currentIndex else 0
                binding.textDikhr.text = azkarList[currentIndex]
            }
            binding.CounterOfDikhr.text = counter.toString()
        }
    }
}