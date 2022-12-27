package com.duck.morseCodeApp.ui.mainscreen


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.isDigitsOnly
import androidx.core.widget.addTextChangedListener
import androidx.navigation.fragment.findNavController
import com.duck.morseCodeApp.databinding.WelcomeScreenBinding


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class WelcomeScreen : Fragment() {

private var _binding: WelcomeScreenBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

      _binding = WelcomeScreenBinding.inflate(inflater, container, false)
      return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // TODO: replace this with a drawer style navigation
        binding.morseChallengeBtn.setOnClickListener {
            val action = WelcomeScreenDirections.actionWelcomeScreenToMorseChallenge()
            action.arguments.putAll(prepareArgs())
            findNavController().navigate(action)
        }

        binding.translateChallengeBtn.setOnClickListener {
            val action = WelcomeScreenDirections.actionWelcomeScreenToTranslateChallenge()
            action.arguments.putAll(prepareArgs())
            findNavController().navigate(action)
        }

        binding.scoreScreenBtn.setOnClickListener {
            val action = WelcomeScreenDirections.actionWelcomeScreenToScoreScreen()
            findNavController().navigate(action)
        }

        binding.userNameEditText.addTextChangedListener {
            if(checkFields()) {
                prepareArgs()
                toggleButtons(true)
            }else
            {
                toggleButtons(false)
            }
        }
        binding.numberOfChallengesEditText.addTextChangedListener {
            if(checkFields()) {
                prepareArgs()
                toggleButtons(true)
            }else
            {
                toggleButtons(false)
            }
        }



    }
    private fun checkFields(): Boolean {
        val userNameText=binding.userNameEditText.text
        val numberOfChallengesText=binding.numberOfChallengesEditText.text
        return userNameText.isNotEmpty()&&
                numberOfChallengesText.isDigitsOnly()&&numberOfChallengesText.isNotEmpty()&&numberOfChallengesText.toString().toInt()>0

    }

    private fun toggleButtons(enable: Boolean) {
        binding.morseChallengeBtn.isEnabled = enable
        binding.translateChallengeBtn.isEnabled = enable
    }

    private fun prepareArgs(): Bundle {
        val bundle = Bundle()//key,Int
        bundle.putString("userName", binding.userNameEditText.text.toString())
        bundle.putInt("numberOfChallenges", binding.numberOfChallengesEditText.text.toString().toInt())
        return bundle
    }

override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}