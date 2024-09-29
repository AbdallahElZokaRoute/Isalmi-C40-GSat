package com.route.islamic40gsat.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.route.islamic40gsat.R
import com.route.islamic40gsat.adapters.VersesAdapter

class HadethFragment : Fragment() {
    lateinit var hadethListRecyclerView: RecyclerView
    lateinit var adapter: VersesAdapter
    lateinit var titlesList: MutableList<String>
    lateinit var descriptionList: MutableList<String>
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_hadeth, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)
    }

    fun initViews(view: View) {
        hadethListRecyclerView = view.findViewById(R.id.hadeth_list_recycler_view)
        val allFileContent = requireActivity().assets.open("ahadeth.txt").bufferedReader().use {
            it.readText()
        }
        val hadethList = allFileContent.split("#")
        titlesList = mutableListOf()
        descriptionList = mutableListOf()
        hadethList.forEach { hadeth ->
            Log.e("hadeth", "initViews 1:  $hadeth")
            val hadethSeparated = hadeth.trim().split("\n")
            Log.e("hadeth", "initViews 2:  ${hadethSeparated.get(0)}")
            titlesList.add(hadethSeparated[0])
            descriptionList.add(hadeth)
        }
        val adapter = VersesAdapter(titlesList)
        hadethListRecyclerView.adapter = adapter

    }
}