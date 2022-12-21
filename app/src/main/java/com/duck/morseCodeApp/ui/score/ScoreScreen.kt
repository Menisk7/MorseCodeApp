package com.duck.morseCodeApp.ui.score

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.duck.morseCodeApp.databinding.ScoreScreenBinding


/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class ScoreScreen : Fragment() {


private var _binding: ScoreScreenBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

      _binding = ScoreScreenBinding.inflate(inflater, container, false)
      return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)





    }
override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}