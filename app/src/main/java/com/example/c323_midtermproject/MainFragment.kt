package com.example.c323_midtermproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.c323_midtermproject.databinding.FragmentMainBinding

/**
 * A simple [Fragment] subclass.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainFragment : Fragment() {

    var restarted = false

    private var _binding: FragmentMainBinding? = null
    private val binding get() =_binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        val view = binding.root
        restarted = MainFragmentArgs.fromBundle(requireArguments()).restart
        var username = MainFragmentArgs.fromBundle(requireArguments()).username
        var guessNum = MainFragmentArgs.fromBundle(requireArguments()).amtGuess
        // initialize application and dao
        val application = requireNotNull(this.activity).application
        val dao = ScoreDatabase.getInstance(application).scoreDao

        // initialize the ViewModelFactory and get the viewModel, then set viewModel and lifecycleOwner
        val viewModelFactory = ScoresViewModelFactory(dao)
        val viewModel = ViewModelProvider(
            this, viewModelFactory).get(ScoresViewModel::class.java)

        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        if (restarted) {
            binding.mainFragText.text = ("$username score: $guessNum\n Play Another Game?")
        }

        binding.playButton.setOnClickListener {
            viewModel.onScoreClicked(0)
        }

        viewModel.navigateToScore.observe(viewLifecycleOwner, Observer { scoreId ->
            scoreId?.let {
                println(scoreId.toString())
                val action = MainFragmentDirections.actionMainFragmentToGameViewFragment(scoreId)
                this.findNavController().navigate(action)
                viewModel.onScoreNavigated()
            }
        })

        binding.viewHsButton.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToHighScoreFragment()
            this.findNavController()
                .navigate(action)
        }
        return view
    }
}