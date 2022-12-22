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
    private var numberOfChallenges:Int=0
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

      _binding = WelcomeScreenBinding.inflate(inflater, container, false)
      return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // TODO: replace this with a drawer style navigation

        binding.morseChallengeBtn.setOnClickListener {
            // TODO: pass arguments form welcomescreen to ChallengeMorse

            val action = WelcomeScreenDirections.actionWelcomeScreenToMorseChallenge()
            findNavController().navigate(action)
        }

        binding.translateChallengeBtn.setOnClickListener {
            val action = WelcomeScreenDirections.actionWelcomeScreenToTranslateChallenge()
            action.arguments.putAll(bundle)
            findNavController().navigate(action)
        }

        binding.scoreScreenBtn.setOnClickListener {
            val action = WelcomeScreenDirections.actionWelcomeScreenToScoreScreen()
            findNavController().navigate(action)
        }
        binding.numberOfChallenges.addTextChangedListener {
            if(binding.numberOfChallenges.text.isDigitsOnly()&&binding.numberOfChallenges.text.isNotEmpty()) {
                binding.morseChallengeBtn.isEnabled=true
            }else
            {
                binding.morseChallengeBtn.isEnabled=false
            }
        }

    }

override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}