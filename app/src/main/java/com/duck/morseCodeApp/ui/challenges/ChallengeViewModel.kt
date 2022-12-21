package com.duck.morseCodeApp.ui.challenges

import androidx.lifecycle.ViewModel
import com.duck.morseCodeApp.data.ChallengeScoreRepository
import com.duck.morseCodeApp.model.ChallengeScore

class ChallengeViewModel(private val repository: ChallengeScoreRepository): ViewModel() {

    fun getScore()=repository.getScore()
    fun addScore(challengeScore: ChallengeScore)=repository.addScore(challengeScore)

}