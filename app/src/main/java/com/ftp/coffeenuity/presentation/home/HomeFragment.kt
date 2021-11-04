package com.ftp.coffeenuity.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ftp.coffeenuity.R
import com.ftp.coffeenuity.data.pref.ProfilePrefs
import com.ftp.coffeenuity.databinding.FragmentHomeBinding
import com.ftp.coffeenuity.utils.Constants

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClick()
        initView()
    }

    private fun initView() {
        with(binding) {
            val welcomeText = "Hi, " + ProfilePrefs.fullname
            tvWelcome.text = welcomeText
        }
    }

    private fun initClick() {
        with(binding) {
            btnIsiKuisioner.setOnClickListener {
                moveToFirstQuestioner()
            }
        }
    }

    private fun moveToFirstQuestioner() {
        when (ProfilePrefs.role) {
            Constants.PETANI -> {
                findNavController().navigate(R.id.action_homeFragment_to_firstQuestionerFragmentPetani)
            }
            Constants.TENGKULAK -> {
                findNavController().navigate(R.id.action_homeFragment_to_firstQuestionerFragmentTengkulak)
            }
            Constants.ROASTERY -> {
                findNavController().navigate(R.id.action_homeFragment_to_firstQuestionerFragmentRoastery)
            }
            else -> {
            }
        }
    }

    override fun onStart() {
        super.onStart()
        if (ProfilePrefs.role == Constants.ADMIN){
            findNavController().navigate(R.id.action_homeFragment_to_adminHomeFragment)
        }
    }
}