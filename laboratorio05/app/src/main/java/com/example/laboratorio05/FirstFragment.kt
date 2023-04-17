package com.example.laboratorio05

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton


class FirstFragment : Fragment() {
    private lateinit var buttonFirstFragment: FloatingActionButton
    private lateinit var cardViewFirst: CardView
    private lateinit var cardViewSecond: CardView




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind()
        buttonFirstFragment.setOnClickListener{
            it.findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
        }
        cardViewFirst.setOnClickListener{
            it.findNavController().navigate(R.id.action_firstFragment_to_thirdFragment)
        }
    }

    private fun bind() {
        buttonFirstFragment = view?.findViewById(R.id.button_first_fragment) as FloatingActionButton
        cardViewFirst= view?.findViewById(R.id.card_view_first) as CardView
        cardViewSecond = view?.findViewById(R.id.card_view_second) as CardView
    }

}