package com.duck.morseCodeApp.ui.challenges

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.duck.morseCodeApp.data.ChallengeScoreRepository


class ChallengeViewModelFactory(private val challengeScoreRepository: ChallengeScoreRepository)
    :ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ChallengeViewModel(challengeScoreRepository) as T
    }
}