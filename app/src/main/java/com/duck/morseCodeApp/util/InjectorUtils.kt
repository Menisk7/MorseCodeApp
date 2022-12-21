package com.duck.morseCodeApp.util

import com.duck.morseCodeApp.data.ChallengeScoreRepository
import com.duck.morseCodeApp.data.FakeDatabase
import com.duck.morseCodeApp.ui.challenges.ChallengeViewModelFactory

object InjectorUtils {
    fun provideChallengeViewModelFactory():ChallengeViewModelFactory{
        val quoteRepository=ChallengeScoreRepository.getInstance(FakeDatabase.getInstance().challengeScoreDao)
        return ChallengeViewModelFactory(quoteRepository)
    }
}