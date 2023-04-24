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
import com.example.laboratorio05.data.model.MovieModel
import com.example.laboratorio05.data.movies
import com.example.laboratorio05.repositories.MovieRepository
import com.example.laboratorio05.ui.movie.MovieViewModel
import com.google.android.material.textfield.TextInputEditText
import org.w3c.dom.Text

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
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind()


        buttonSecondFragment.setOnClickListener(){
            var movieToday= MovieModel(editTextName.text.toString(), editTextCategory.text.toString(), editTextDescription.text.toString(), editTextCualification.text.toString())
            movieViewModel.addMovies(movieToday)
            Log.d("movies", movieViewModel.getMovies().toString())



        }


    }

    private fun bind(){
        buttonSecondFragment = view?.findViewById(R.id.secondFragmentButton)!!
        editTextName= view?.findViewById(R.id.textInputEditText) !!
        editTextCategory= view?.findViewById(R.id.textInputEditText2) !!
        editTextDescription= view?.findViewById(R.id.textInputEditText3) !!
        editTextCualification= view?.findViewById(R.id.textInputEditText4) !!
    }


    }

