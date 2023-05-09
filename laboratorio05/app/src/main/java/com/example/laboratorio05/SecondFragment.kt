package com.example.laboratorio05

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.laboratorio05.databinding.FragmentSecondBinding
import com.example.laboratorio05.ui.movie.viewmodel.MovieViewModel

class SecondFragment : Fragment() {
    // TODO: Rename and change types of parameters

private lateinit var buttonSecondFragment: Button
private lateinit var editTextName: EditText
private lateinit var editTextCategory: EditText
private lateinit var editTextDescription: EditText
private lateinit var editTextCualification: EditText

private val movieViewModel: MovieViewModel by activityViewModels {
    MovieViewModel.Factory


}
    private lateinit var binding: FragmentSecondBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun observeStatus(){
        movieViewModel.status.observe(viewLifecycleOwner){ status ->

            when{
                status.equals(MovieViewModel.WRONG_INFORMATION) ->{
                    Log.d("APP_TAG", status)
                    movieViewModel.clearStatus()

            }
                status.equals(MovieViewModel.MOVIE_CREATED) -> {
                    Log.d("APP_TAG", status)
                    Log.d("APP_TAG", movieViewModel.getMovies().toString())
                    movieViewModel.clearStatus()
                    findNavController().popBackStack()
                }

            }
        }
    }
    private fun setViewModel() {
        binding.viewmodel = movieViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind()
        setViewModel()
        observeStatus()

    }

    private fun bind(){
        buttonSecondFragment = view?.findViewById(R.id.secondFragmentButton)!!
        editTextName= view?.findViewById(R.id.textInputEditText) !!
        editTextCategory= view?.findViewById(R.id.textInputEditText2) !!
        editTextDescription= view?.findViewById(R.id.textInputEditText3) !!
        editTextCualification= view?.findViewById(R.id.textInputEditText4) !!
    }


    }

