package com.duck.morseCodeApp

class MorseCode {
    private val morseDictionary = mutableMapOf<String,String>(
        "a"  to ".-",
        "b"  to "-...",
        "c"  to "-.-.",
        "d"  to "-..",
        "e"  to ".",
        "f"  to "..-.",
        "g"  to "--.",
        "h"  to "....",
        "i"  to "..",
        "j"  to ".---",
        "k"  to "-.-",
        "l"  to ".-..",
        "m"  to "--",
        "n"  to "-.",
        "o"  to "---",
        "p"  to ".--.",
        "q"  to "--.-",
        "r"  to ".-.",
        "s"  to "...",
        "t"  to "-",
        "u"  to "..-",
        "v"  to "...-",
        "w"  to ".--",
        "x"  to "-..-",
        "y"  to "-.--",
        "z"  to "--..",
        "0"  to "-----",
        "1"  to ".----",
        "2"  to "..---",
        "3"  to "...--",
        "4"  to "....-",
        "5"  to ".....",
        "6"  to "-....",
        "7"  to "--...",
        "8"  to "---..",
        "9"  to "----.",
        "&"  to  ".-...",
        "\'" to  ".----.",
        "@"  to  ".--.-.",
        ")"  to  "-.--.-",
        "("  to  "-.--.",
        ":"  to  "---...",
        ","  to  "--..--",
        "="  to  "-...-",
        "!"  to  "-.-.--",
        "."  to  ".-.-.-",
        "-"  to  "-....-",
        "+"  to	 ".-.-.",
        "\"" to  ".-..-.",
        "?"	 to  "..--..",
        "/"	 to  "-..-.",
        ""   to  " ",
        " "  to  ""
    )

    private val textDictionary = mutableMapOf<String,String>(
       ".-"    to "a",
       "-..."  to "b" ,
       "-.-."  to "c",
       "-.."   to "d" ,
       "."     to "e" ,
       "..-."  to "f" ,
       "--."   to "g" ,
       "...."  to "h" ,
       ".."    to "i" ,
       ".---"  to "j" ,
       "-.-"   to "k" ,
       ".-.."  to "l" ,
       "--"    to "m" ,
       "-."    to "n" ,
       "---"   to "o" ,
       ".--."  to "p" ,
       "--.-"  to "q" ,
       ".-."   to "r" ,
       "..."   to "s" ,
       "-"     to "t" ,
       "..-"   to "u" ,
       "...-"  to "v" ,
       ".--"   to "w" ,
       "-..-"  to "x" ,
       "-.--"  to "y" ,
       "--.."  to "z" ,
       "-----" to "0" ,
       ".----" to "1" ,
       "..---" to "2" ,
       "...--" to "3" ,
       "....-" to "4" ,
       "....." to "5" ,
       "-...." to "6" ,
       "--..." to "7" ,
       "---.." to "8" ,
       "----." to "9" ,
       ".-..." to "&" ,
       ".----" to "\'",
       ".--.-" to "@" ,
       "-.--." to ")" ,
       "-.--." to "(" ,
       "---.." to ":" ,
       "--..-" to "," ,
       "-...-" to "=" ,
       "-.-.-" to "!" ,
       ".-.-." to "." ,
       "-...." to "-" ,
       ".-.-." to "+",
       ".-..-" to "\"",
       "..--." to "?",
       "-..-." to "/",
       ""      to " "
    )





//    private var data = HashBiMap.create(morseDictionary)
//
//    fun getDictionary(): HashBiMap<String, String> {
//        return data;
//    }

    // TODO: fix encode and fix decode double spaces are now a break in words written in morsecode
    fun encode(usrInput:String): String {
        var output=""

        val letterArray= mutableListOf<String>()
        for (letter in usrInput){
            if(letter!=' ')
                letterArray+=morseDictionary[letter.toString()].toString()
            else{
                letterArray+=" "
            }
        }

        for (item in letterArray){
            output+=item
        }

        return output.trimEnd()
    }

    fun decode(morseInput:String): String {
        var output=""
        var word=""
        val wordArray= mutableListOf<String>()


        for (char in morseInput) {
            if(char !=' ')
                word+=char
            else {
                wordArray+= word
                word=""
            }

        }
        wordArray+= word
        for (item in wordArray)
        {
            output+= textDictionary[item].toString()
        }



        return output
    }

}