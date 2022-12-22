package com.duck.morseCodeApp.ui.challenges


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.duck.morseCodeApp.util.MorseCode
import com.duck.morseCodeApp.databinding.MorseChallengeBinding
import com.duck.morseCodeApp.model.ChallengeScore
import com.duck.morseCodeApp.ui.mainscreen.WelcomeScreenArgs
import com.duck.morseCodeApp.util.InjectorUtils





/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class ChallengeMorse : Fragment() {

    private lateinit var challengeViewModel: ChallengeViewModel
    private var _binding: MorseChallengeBinding? = null
    private val binding get() = _binding!!
    private var numberOfChallenge:Int=0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      _binding = MorseChallengeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        setup()
        val factory= InjectorUtils.provideChallengeViewModelFactory()
         challengeViewModel =
            //this returns challengeViewModel which manipulates challengeRepository
            ViewModelProvider(this, factory).get(ChallengeViewModel::class.java)
        val cs:ChallengeScore=ChallengeScore("testUser",10)
        //challengeViewModel.addScore(cs)
        //only for testing


        return root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

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
        binding.next.setOnClickListener {
            val action = ChallengeMorseDirections.actionMorseChallengeToScoreScreen()
            findNavController().navigate(action)
        }

    }

    private fun setup(){
        binding.promptText.setText("a")
    }
    fun validateInput(){

        val morseCode= MorseCode()
        val encodedLetter=morseCode.encode(binding.promptText.text.toString())
        val userInput=morseCode.decode(binding.inputText.text.toString())
        println(userInput + " userInput")
        println(encodedLetter + "encodedLetter")
        if(userInput == binding.promptText.text.toString()) {
            ++numberOfChallenge
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