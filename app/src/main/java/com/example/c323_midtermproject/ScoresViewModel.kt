package com.example.c323_midtermproject

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
class ScoresViewModel(val dao: ScoreDao) : ViewModel() {
    var newUserName = ""
    var newHighScore = 0
    val scores = dao.getAll()
    private val _navigateToScore = MutableLiveData<Long?>()
    val navigateToScore : LiveData<Long?>
        get() =_navigateToScore

    /**
     * Add a new score with newScoreUsername and newHighScore being set
     */
    fun addNote() {
        viewModelScope.launch {
            val score = Score()
            score.scoreUser = newUserName
            score.scoreNum = newHighScore
            dao.insert(score)
        }
    }
    /**
     * Delete note based on note's value
     */
    fun deleteScore(scoreId: Long) {
        viewModelScope.launch {
            val score = Score()
            score.scoreId = scoreId
            dao.delete(score)
        }
    }

    fun onScoreClicked(scoreId: Long) {
        _navigateToScore.value = scoreId
    }
    fun onScoreNavigated() {
        _navigateToScore.value = null
    }
}