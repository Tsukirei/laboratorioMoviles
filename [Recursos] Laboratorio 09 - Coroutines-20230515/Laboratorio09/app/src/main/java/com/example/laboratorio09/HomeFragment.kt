package com.example.laboratorio09

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.findViewTreeViewModelStoreOwner
import androidx.navigation.findNavController
import com.example.corutinesdemo.R
import com.example.corutinesdemo.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        actionButton()
        //TODO: Use binding to navigate to the other fragments
    }

    fun actionButton(){
        binding.coroutinesButton.setOnClickListener(){
    it.findNavController().navigate(R.id.action_homeFragment2_to_coroutinesFragment3)
        }
        binding.mainThreadButton.setOnClickListener(){
            it.findNavController().navigate(R.id.action_homeFragment2_to_mainThreadFragment2)
        }
        }
    }
