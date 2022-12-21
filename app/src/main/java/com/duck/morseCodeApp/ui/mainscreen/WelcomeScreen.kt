package com.duck.morseCodeApp.ui.mainscreen


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.duck.morseCodeApp.R
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
    ): View? {

      _binding = WelcomeScreenBinding.inflate(inflater, container, false)
      return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // TODO: replace this with a drawer style navigation  
        binding.morseChallengeBtn.setOnClickListener { findNavController().navigate(R.id.action_welcomeScreen_to_morseChallenge) }
        binding.translateChallengeBtn.setOnClickListener { findNavController().navigate(R.id.action_welcomeScreen_to_translateChallenge) }
        binding.scoreScreenBtn.setOnClickListener { findNavController().navigate(R.id.action_welcomeScreen_to_scoreScreen) }

    }

override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}