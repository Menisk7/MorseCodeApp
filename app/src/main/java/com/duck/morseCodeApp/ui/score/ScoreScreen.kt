package com.duck.morseCodeApp.ui.score

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.duck.morseCodeApp.R
import com.duck.morseCodeApp.databinding.MorseChallengeBinding
import com.duck.morseCodeApp.databinding.ScoreScreenBinding
import com.duck.morseCodeApp.ui.challenges.ChallengeViewModel
import com.duck.morseCodeApp.util.InjectorUtils


/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class ScoreScreen : Fragment() {

    private lateinit var challengeViewModel: ChallengeViewModel
    private var _binding: ScoreScreenBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ScoreScreenBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val factory= InjectorUtils.provideChallengeViewModelFactory()
        challengeViewModel =
            //this returns challengeViewModel which manipulates challengeRepository
            ViewModelProvider(this, factory).get(ChallengeViewModel::class.java)
        challengeViewModel.getScore().observe(viewLifecycleOwner, Observer { user->
            val stringBuilder=StringBuilder()
            user.forEach { score ->
                stringBuilder.append("${score.user} ${score.points}\n")
            }
            binding.scoreTextView.text=stringBuilder.toString()
        })
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}