package com.duck.morseCodeApp.util

import android.icu.util.Calendar
import kotlin.random.Random

class RandomGenerator {
    fun getRandom(): Random {
        val calendar = Calendar.getInstance()
        val hours = calendar.get(Calendar.HOUR_OF_DAY)
        val month = calendar.get(Calendar.MONTH)
        val year = calendar.get(Calendar.YEAR)
        val days = calendar.get(Calendar.DAY_OF_YEAR)
        val miliSeconds = calendar.get(Calendar.MILLISECOND)
        val seed = hours * 7 + days + miliSeconds * 6 + month + year

        return Random(seed.toLong())
    }
}
