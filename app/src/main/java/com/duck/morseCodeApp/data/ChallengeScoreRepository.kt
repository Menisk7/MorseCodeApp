package com.duck.morseCodeApp.data

import com.duck.morseCodeApp.model.ChallengeScore


class ChallengeScoreRepository private constructor(private val challengeScoreDao: ChallengeScoreDao){
    //manipulated ChallengeScoreDao  Data access object
    fun addScore(challengeScore: ChallengeScore){
        challengeScoreDao.addScore(challengeScore)

    }
    fun modifyScore(user: String, points: Int) {
        challengeScoreDao.modifyScore(user, points)
    }
    fun getUsers(): List<String> {
        return challengeScoreDao.getUsers()
    }

    fun getScore()=challengeScoreDao.getScore()
    companion object {
        @Volatile private var instance: ChallengeScoreRepository? = null

        fun getInstance(challengeScoreDao: ChallengeScoreDao) =
            instance ?: synchronized(this) {
                instance ?: ChallengeScoreRepository(challengeScoreDao).also { instance = it }
            }

    }
}