package com.example.c323_midtermproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.c323_midtermproject.databinding.FragmentMainBinding

/**
 * A simple [Fragment] subclass.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() =_binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.playButton.setOnClickListener{
            val action = MainFragmentDirections.actionMainFragmentToGameViewFragment()
            this.findNavController()
                .navigate(action)
        }

        binding.viewHsButton.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToHighScoreFragment()
            this.findNavController()
                .navigate(action)
        }
        return view
    }
}