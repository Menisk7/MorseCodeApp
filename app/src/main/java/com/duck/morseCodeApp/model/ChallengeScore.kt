package com.duck.morseCodeApp.model

data class ChallengeScore(val user: String,
                          var points:Int){
    override fun toString(): String {
        return "$user $points"
    }
}