package com.example.c323_midtermproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.c323_midtermproject.databinding.FragmentHighScoreBinding


/**
 * A simple [Fragment] subclass.
 * Use the [HighScoreFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HighScoreFragment : Fragment() {
    private var _binding: FragmentHighScoreBinding? = null
    private val binding get() =_binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHighScoreBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.butBackHome.setOnClickListener {
            val action = HighScoreFragmentDirections.actionHighScoreFragmentToMainFragment()
            this.findNavController()
                .navigate(action)
        }
        return view
    }
}