package com.example.c323_midtermproject

import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.c323_midtermproject.databinding.FragmentGameViewBinding


/**
 * A simple [Fragment] subclass.
 * Use the [GameViewFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GameViewFragment : Fragment() {
    // initialize binding and add non-null asserted calls
    private var _binding: FragmentGameViewBinding? = null
    private val binding get() = _binding!!

    var guessNum = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentGameViewBinding.inflate(inflater, container, false)
        val view = binding.root
        val scoreId = GameViewFragmentArgs.fromBundle(requireArguments()).scoreId

        // initialize application and dao
        val application = requireNotNull(this.activity).application
        val dao = ScoreDatabase.getInstance(application).scoreDao

        // initialize the ViewModelFactory and get the viewModel, then set viewModel and lifecycleOwner
        val viewModelFactory = EditScoreViewModelFactory(scoreId, dao)
        val viewModel = ViewModelProvider(this, viewModelFactory)
            .get(EditScoreViewModel::class.java)

        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        val correctNum = viewModel.genNewNum()
        println(correctNum)

        binding.butMinus.setOnClickListener {
            if (binding.etGuess.text.toString() != "") {
                var num = binding.etGuess.text.toString().toInt() - 5
                binding.etGuess.setText(num.toString())
            }
        }

        binding.butPlus.setOnClickListener {
            if (binding.etGuess.text.toString() != "") {
                var num = binding.etGuess.text.toString().toInt() + 5
                binding.etGuess.setText(num.toString())
            }
        }

        binding.butGuess.setOnClickListener {
                guessNum++
                binding.tvGuessCount.setText(guessNum.toString())
                val curGuess = binding.etGuess.text.toString()

                if (curGuess == (correctNum.toString())) {
                    viewModel.updateScore()
                    val action = GameViewFragmentDirections.actionGameViewFragmentToMainFragment()
                    action.restart = true
                    action.username = binding.etName.text.toString()
                    action.amtGuess = guessNum
                    this.findNavController()
                        .navigate(action)
                }
                else {
                    if (curGuess.toInt() > correctNum) {
                        showToast("Too High!")
                        var mediaPlayer = MediaPlayer.create(context, R.raw.buzz)
                        mediaPlayer.start()
                    }
                    else {
                        showToast("Too Low!")
                        var mediaPlayer = MediaPlayer.create(context, R.raw.buzz)
                        mediaPlayer.start()
                    }
                }
            }
        return view
    }

    /**
     * This function is a helper for the onCreate to show toasts based on what message is required
     */
    fun showToast(message: String, duration: Int = Toast.LENGTH_SHORT){
        Toast.makeText(context, message , duration).show()
    }
}