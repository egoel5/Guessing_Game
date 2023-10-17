package com.example.c323_midtermproject

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ScoresViewModelFactory(private val dao: ScoreDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ScoresViewModel::class.java)) {
            return ScoresViewModel(dao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel")
    }

}