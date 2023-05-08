package com.example.laboratorio05.ui.movie.billboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.cardview.widget.CardView
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.laboratorio05.R
import com.example.laboratorio05.data.model.MovieModel
import com.example.laboratorio05.databinding.FragmentFirstBinding
import com.example.laboratorio05.ui.movie.billboard.recyclerview.MovieRecyclerViewAdapter
import com.example.laboratorio05.ui.movie.viewmodel.MovieViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton


class FirstFragment : Fragment() {
    private lateinit var buttonFirstFragment: FloatingActionButton


    private lateinit var adapter: MovieRecyclerViewAdapter
    private lateinit var binding: FragmentFirstBinding


    private val movieViewModel: MovieViewModel by activityViewModels {
        MovieViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind()
        buttonFirstFragment.setOnClickListener{
            it.findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
        }

        setRecyclerView(view)
        binding.buttonFirstFragment.setOnClickListener(){
            movieViewModel.clearData()
            it.findNavController().navigate(R.id.action_firstFragment_to_secondFragment)

        }
    }
     private fun showSelectedItem(movie: MovieModel){


       movieViewModel.setSelectedMovies(movie)
        findNavController().navigate(R.id.action_firstFragment_to_secondFragment)

    }
    private fun displayMovies(){
        adapter.setData(movieViewModel.getMovies())
    }

    private fun bind() {


    }

    private fun setRecyclerView(view: View) {
        binding.RecyclerView.layoutManager = LinearLayoutManager(view.context)
        adapter = MovieRecyclerViewAdapter { selectedMovie ->
            showSelectedItem(selectedMovie)
        }
    binding.RecyclerView.adapter = adapter
        displayMovies()
    }

}