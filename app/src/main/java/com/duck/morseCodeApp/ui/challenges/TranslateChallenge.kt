package com.duck.morseCodeApp.ui.challenges


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.duck.morseCodeApp.util.MorseCode
import com.duck.morseCodeApp.databinding.TranslateChallengeBinding


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class TranslateChallenge : Fragment() {

private var _binding: TranslateChallengeBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

      _binding = TranslateChallengeBinding.inflate(inflater, container, false)
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

    private fun setup(){
        binding.promptText.setText("a")
    }
    private fun validateInput(){
        val morseCode= MorseCode()
        val promptTextDecoded=morseCode.decode(binding.promptText.text.toString())
        val userInput=binding.inputText.text.toString()
        println("$userInput userInput")
        println(promptTextDecoded + "promptTextDecoded")
        if(userInput == promptTextDecoded) {
            Toast.makeText(binding.root.context.applicationContext, "Correct!", Toast.LENGTH_LONG)
                .show()

        }
        else
            Toast.makeText(binding.root.context.applicationContext,"Wrong!", Toast.LENGTH_LONG).show()

    }

override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}