package com.duck.morseCodeApp.ui.challenges


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.duck.morseCodeApp.util.MorseCode
import com.duck.morseCodeApp.databinding.MorseChallengeBinding


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class MorseChallenge : Fragment() {

private var _binding: MorseChallengeBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



      _binding = MorseChallengeBinding.inflate(inflater, container, false)
      return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        setup()
        binding.enterBtn.setOnClickListener{
            validateInput()
        }
        binding.dashBtn.setOnClickListener {
            binding.inputText.append("-")
        }
        binding.dotBtn.setOnClickListener {
            binding.inputText.append(".")
        }
        binding.backspaceBtn.setOnClickListener {
            if (binding.inputText.text.toString()!="")
                binding.inputText.setText(binding.inputText.text.substring(0,binding.inputText.length()-1))
        }
        binding.spaceBtn.setOnClickListener {
            binding.inputText.append(" ")
        }
        binding.doubleSpaceBtn.setOnClickListener {
            binding.inputText.append("  ")
        }

    }

    fun setup(){
        binding.promptText.setText("a")
    }
    fun validateInput(){
        val morseCode= MorseCode()
        val encodedLetter=morseCode.encode(binding.promptText.text.toString())
        val userInput=morseCode.decode(binding.inputText.text.toString())
        println(userInput + " userInput")
        println(encodedLetter + "encodedLetter")
        if(userInput == binding.promptText.text.toString()) {
            Toast.makeText(binding.root.context.applicationContext, "Correct!", Toast.LENGTH_LONG)
                .show()

        }
        else
            Toast.makeText(binding.root.context.applicationContext,"Wrong!",Toast.LENGTH_LONG).show()

    }

override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}