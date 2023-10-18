package com.example.c323_midtermproject

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class EditScoreViewModel(scoreId: Long, val dao: ScoreDao) : ViewModel() {
    var score = MutableLiveData<Score>()
    val scoreId : Long = scoreId
    private val _navigateToList = MutableLiveData<Boolean>(false)
    val navigateToList: LiveData<Boolean>
        get() = _navigateToList

    init {
        dao.get(scoreId).observeForever{ it ->
            if(it == null) {
                score.value = Score()
            } else {
                score.value = it
            }
        }
    }

    fun updateScore() {
        viewModelScope.launch {
            Log.v("a", dao.getAll().toString())
                dao.insert(score.value!!)
            }
            _navigateToList.value = true
    }
    fun deleteScore() {
        viewModelScope.launch {
            dao.delete(score.value!!)
            _navigateToList.value = true
        }
    }
    fun onNavigatedToList() {
        _navigateToList.value = false
    }

    override fun onCleared() {
        super.onCleared()
    }

    fun genNewNum() : Int {
        return (1..100).random()
    }
}