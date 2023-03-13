package com.duck.morseCodeApp.ui.score

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.activity.OnBackPressedDispatcher
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.duck.morseCodeApp.R
import com.duck.morseCodeApp.databinding.ScoreScreenBinding
import com.duck.morseCodeApp.ui.challenges.ChallengeViewModel
import com.duck.morseCodeApp.util.InjectorUtils
import androidx.activity.OnBackPressedDispatcherOwner
import androidx.activity.addCallback
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.duck.morseCodeApp.ui.mainscreen.MainActivity

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
private lateinit var recyclerView: RecyclerView
class ScoreScreen : Fragment(), OnBackPressedDispatcherOwner {

    private lateinit var challengeViewModel: ChallengeViewModel
    private var _binding: ScoreScreenBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ScoreScreenBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val scoreItemList = mutableListOf<ScoreItem>()
        val factory= InjectorUtils.provideChallengeViewModelFactory()
        challengeViewModel =
                //this returns challengeViewModel which manipulates challengeRepository
            ViewModelProvider(this, factory).get(ChallengeViewModel::class.java)
        challengeViewModel.getScore().observe(viewLifecycleOwner, Observer { user->
            val stringBuilder=StringBuilder()
            user.forEach { score ->
                scoreItemList.add(ScoreItem(score.user, score.points))
            }
            recyclerView = view.findViewById(R.id.listRecycler)
            val adapter = ScoreAdapter(scoreItemList.toList(), layoutInflater)
            recyclerView.layoutManager= LinearLayoutManager(requireContext())
            recyclerView.adapter = adapter
        })

        val toolbar = (activity as MainActivity).findViewById<Toolbar>(R.id.toolbar)
        // Set a click listener for the back button in the app bar
        toolbar.setNavigationOnClickListener {
            // Navigate to the first fragment
            val navController = findNavController()
            navController.popBackStack(R.id.welcomeScreen,  false)
        }


        onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            // Navigate to the first fragment
            val navController = findNavController()
            navController.popBackStack(R.id.welcomeScreen,  false)

        }
    }
override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun getOnBackPressedDispatcher(): OnBackPressedDispatcher {
        return requireActivity().onBackPressedDispatcher
    }



}