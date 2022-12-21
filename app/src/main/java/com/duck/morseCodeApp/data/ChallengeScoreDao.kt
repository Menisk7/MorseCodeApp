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
    fun getPoints() =users as LiveData<List<ChallengeScore>>

}