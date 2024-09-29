package com.route.islamic40gsat.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.route.islamic40gsat.R

class TasbeehFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.fragment_tasbeeh,
            container, false
        )
    }
    lateinit var tasbehBTN : Button
    lateinit var sebhaIV : ImageView
    lateinit var numtasbehTV : TextView
    var counterTasbeh = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tasbehBTN = view.findViewById(R.id.btn_tasbeh)
        sebhaIV = view.findViewById(R.id.iv_body_sebha)
        numtasbehTV = view.findViewById(R.id.tv_sebha_counter)
        tasbehBTN.setOnClickListener(View.OnClickListener {
            counterTasbeh++
            numtasbehTV.text = counterTasbeh.toString()
        })
        sebhaIV.setOnClickListener(View.OnClickListener {
            counterTasbeh++
            numtasbehTV.text = counterTasbeh.toString()
        })
    }
}