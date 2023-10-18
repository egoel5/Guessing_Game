package com.example.c323_midtermproject

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.get
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.c323_midtermproject.databinding.FragmentHighScoreBinding


/**
 * A simple [Fragment] subclass.
 * Use the [HighScoreFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HighScoreFragment : Fragment() {
    // initialize binding and add non-null asserted calls
    private var _binding: FragmentHighScoreBinding? = null
    private val binding get() =_binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHighScoreBinding.inflate(inflater, container, false)
        val view = binding.root

        // initialize application and dao
        val application = requireNotNull(this.activity).application
        val dao = ScoreDatabase.getInstance(application).scoreDao

        // initialize the ViewModelFactory and get the viewModel, then set viewModel and lifecycleOwner
        val viewModelFactory = ScoresViewModelFactory(dao)
        val viewModel = ViewModelProvider(
            this, viewModelFactory).get(ScoresViewModel::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        /**
         * noteClicked : run onNoteClicked from viewModel using the noteId of the note that was clicked
         */
        fun scoreClicked (noteId : Long) {
            viewModel.onScoreClicked(noteId)
        }

        /**
         * yesPressed : if yes is pressed on confirmation dialog, run deleteNote from viewModel
         * using noteId whose delButton was pressed
         */
        fun yesPressed(scoreId : Long) {
            binding.viewModel?.deleteScore(scoreId)
        }
        /**
         * deleteClicked : create a confirmation dialog to delete note whose delButton was pressed
         */
        fun deleteClicked (noteId : Long) {
            ConfirmDeleteDialogFragment(noteId,::yesPressed).show(childFragmentManager,
                ConfirmDeleteDialogFragment.TAG)
        }

        // initialize and set adapter
        val adapter = ScoreItemAdapter(::scoreClicked, ::deleteClicked)
        binding.scoresList.adapter

        // when a notes item is observed, submitList of notes to the adapter
        viewModel.scores.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.submitList(it)
            }
        })

        if (viewModel.scores.value == null) {
            Log.v("a", "empty")
            binding.scoresList.visibility = View.INVISIBLE
            binding.tvNoScores.visibility = View.VISIBLE
        }

        binding.butBackHome.setOnClickListener {
            val action = HighScoreFragmentDirections.actionHighScoreFragmentToMainFragment()
            this.findNavController()
                .navigate(action)
        }
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}