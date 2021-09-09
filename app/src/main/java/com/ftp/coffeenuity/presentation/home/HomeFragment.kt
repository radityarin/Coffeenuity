package com.ftp.coffeenuity.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ftp.coffeenuity.R
import com.ftp.coffeenuity.data.pref.ProfilePrefs
import com.ftp.coffeenuity.data.source.remote.network.request.PetaniRequest
import com.ftp.coffeenuity.data.utils.Resource
import com.ftp.coffeenuity.databinding.FragmentHomeBinding
import com.ftp.coffeenuity.presentation.auth.FuzzyViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val fuzzyViewModel: FuzzyViewModel by viewModel()

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
        with(binding){
            tvWelcome.text = "Hi, " + ProfilePrefs.fullname
        }
    }

    private fun initClick() {
        with(binding){
            btnIsiKuisioner.setOnClickListener { findNavController().navigate(R.id.action_homeFragment_to_firstQuestionerFragmentPetani) }
        }
    }
}