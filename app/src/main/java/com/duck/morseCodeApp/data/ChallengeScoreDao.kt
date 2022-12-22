package com.duck.morseCodeApp.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.duck.morseCodeApp.model.ChallengeScore


class ChallengeScoreDao {
    //Data access object
    private val userlist= mutableListOf<ChallengeScore>()
    private val users=MutableLiveData<List<ChallengeScore>>()
    init {
        users.value=userlist
    }
    fun addScore(challengeScore: ChallengeScore){
        userlist.add(challengeScore)
        users.value=userlist
    }
    fun modifyScore(user: String, points: Int) {
        val userScore = userlist.find { it.user == user }
        if (userScore != null) {
            userScore.points = points
            users.value = userlist
        }
    }
    fun getScore() =users as LiveData<List<ChallengeScore>>

}