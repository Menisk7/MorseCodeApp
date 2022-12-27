package com.duck.morseCodeApp.ui.challenges


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.duck.morseCodeApp.util.MorseCode
import com.duck.morseCodeApp.databinding.MorseChallengeBinding
import com.duck.morseCodeApp.model.ChallengeScore
import com.duck.morseCodeApp.util.InjectorUtils





/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class ChallengeMorse : Fragment() {

    private lateinit var challengeViewModel: ChallengeViewModel
    private var _binding: MorseChallengeBinding? = null
    private val binding get() = _binding!!
    private var numberOfChallenge:Int=1
    private var chosenNumberOfChallenges:Int=10
    private val morseCode=MorseCode()
    private var points:Int=0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
      _binding = MorseChallengeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        setup()
        val factory= InjectorUtils.provideChallengeViewModelFactory()
         challengeViewModel =
            //this returns challengeViewModel which manipulates challengeRepository
             ViewModelProvider(this, factory)[ChallengeViewModel::class.java]
        val username=requireArguments().getString("userName")!!
        val cs =ChallengeScore(username,0)
        //only for testing
        challengeViewModel.addScore(cs)
        //val users=challengeViewModel.getUsers()
        //val user = users.find { it == "test" }


        return root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        val action = ChallengeMorseDirections.actionMorseChallengeToScoreScreen()
        binding.enterBtn.setOnClickListener{
            process()
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
            findNavController().navigate(action)
        }

    }

    private fun setup(){
        chosenNumberOfChallenges = requireArguments().getInt("numberOfChallenges")
        nextChallengeUpdate()
        updateProgressTextView()
    }

    private fun updateProgressTextView(){
        val score="$numberOfChallenge/$chosenNumberOfChallenges"
        binding.progressTextView.text = score
    }

    private fun nextChallengeUpdate(){
        binding.promptText.setText(morseCode.generateMorseChallenge())
    }

    private fun clearEditTexts() {
        binding.inputText.text.clear()
        binding.promptText.text.clear()
    }

    private fun toNextChallenge(state:Boolean){
        if(state){
            updateProgressTextView()
            clearEditTexts()
            nextChallengeUpdate()
        }
    }

    private fun showResponse(isCorrect:Boolean)
    {
        if(isCorrect) Toast.makeText(binding.root.context.applicationContext, "Correct!", Toast.LENGTH_LONG).show()
        else Toast.makeText(binding.root.context.applicationContext,"Wrong!",Toast.LENGTH_LONG).show()
    }
    private fun setFinalScore()
    {challengeViewModel.modifyScore(requireArguments().getString("userName")!!,points)}

    private fun validateInput(): Boolean {
        val userInput=morseCode.decode(binding.inputText.text.toString())
        return userInput == binding.promptText.text.toString()
    }
    private fun process(){
        if (validateInput()) {
            ++points
            ++numberOfChallenge
            showResponse(true)
            toNextChallenge(numberOfChallenge <= chosenNumberOfChallenges)
        }else{
            showResponse(false)
        }
        if(numberOfChallenge>chosenNumberOfChallenges)
        {
            setFinalScore()
            val action = ChallengeMorseDirections.actionMorseChallengeToScoreScreen()
            findNavController().navigate(action)
        }
    }

override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}