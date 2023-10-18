package com.example.c323_midtermproject

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
class ScoresViewModel(val dao: ScoreDao) : ViewModel() {
    val newScoreUser = "New User"
    val scores = dao.getAll()
    private val _navigateToScore = MutableLiveData<Long?>()
    val navigateToScore : LiveData<Long?>
        get() =_navigateToScore

    /**
     * Add a new score with newScoreUsername and newHighScore being set
     */
    fun addScore() {
        viewModelScope.launch {
            val score = Score()
            score.scoreUser = newScoreUser
            dao.insert(score)
        }
    }
    /**
     * Delete score based on score's value
     */
    fun deleteScore(scoreId: Long) {
        viewModelScope.launch {
            val score = Score()
            score.scoreId = scoreId
            dao.delete(score)
        }
    }

    /**
     * make sure navigateToList's value is proper so it doesn't go to GameViewFragment when it shouldn't
     */

    fun onScoreClicked(scoreId: Long) {
        _navigateToScore.value = scoreId
    }
    fun onScoreNavigated() {
        _navigateToScore.value = null
    }
}