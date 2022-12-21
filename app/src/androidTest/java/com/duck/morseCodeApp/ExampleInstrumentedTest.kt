package com.duck.morseCodeApp

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.duck.morseCodeApp.util.MorseCode

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.myapplication", appContext.packageName)
    }



    @Test
    fun v() {
        val morseCode= MorseCode()

        var word=""
        word=morseCode.encode("abc d")
        println(word)

        var decoded=morseCode.decode(word)
        println(decoded)



        assertEquals(".- -... -.-.  -..",word)
        assertEquals("abc d",decoded)
    }
}