package com.example.c323_midtermproject

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class EditScoreViewModelFactory(private val scoreId: Long,
                                private val dao: ScoreDao)
    : ViewModelProvider.Factory  {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(EditScoreViewModel::class.java)) {
            return EditScoreViewModel(scoreId, dao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel")
    }
}