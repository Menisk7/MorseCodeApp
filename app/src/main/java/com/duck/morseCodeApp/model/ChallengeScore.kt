package com.duck.morseCodeApp.model

data class ChallengeScore(var user: String,
                          val points:Int){
    override fun toString(): String {
        return "$user $points"
    }
}