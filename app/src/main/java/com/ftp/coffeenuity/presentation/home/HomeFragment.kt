package com.ftp.coffeenuity.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ftp.coffeenuity.R
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
        val testPetaniSubKriteria = listOf(
            listOf(1, 3, 5),
            listOf(1, 3),
            listOf(1)
        )

        val testPetaniSosial = listOf(
            listOf(1, 1, 1, 1, 1, 1, 3, 3),
            listOf(1, 3, 3, 3, 1, 1, 1),
            listOf(1, 3, 3, 3, 3, 3),
            listOf(1, 3, 3, 1, 1),
            listOf(1, 1, 1, 1),
            listOf(1, 1, 1),
            listOf(1, 1),
            listOf(1)
        )
        val testPetaniEkonomi = listOf(
            listOf(1, 1, 3, 3, 3, 1),
            listOf(1, 1, 3, 3, 3),
            listOf(1, 3, 3, 1),
            listOf(1, 1, 1),
            listOf(1, 1),
            listOf(1)
        )

        val testPetaniLingkungan = listOf(
            listOf(1, 1, 3, 3),
            listOf(1, 3, 5),
            listOf(1, 3),
            listOf(1)
        )

        val skalaKriteriaEkonomi = listOf<Int>(3, 2, 5, 4, 4, 3)
        val skalaKriteriaSosial = listOf<Int>(3, 3, 4, 5, 4, 4, 3, 5)
        val skalaKriteriaLingkungan = listOf<Int>(3, 5, 3, 4)

        val petaniRequest = PetaniRequest(
            testPetaniSubKriteria = testPetaniSubKriteria,
            testPetaniEkonomi = testPetaniEkonomi,
            testPetaniSosial = testPetaniSosial,
            testPetaniLingkungan = testPetaniLingkungan,
            skalaKriteriaEkonomi = skalaKriteriaEkonomi,
            skalaKriteriaSosial = skalaKriteriaSosial,
            skalaKriteriaLingkungan = skalaKriteriaLingkungan
        )

        fuzzyViewModel.getIndeksBerkelanjutanPetani(petaniRequest).observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Loading -> {
                    println("loading")
                }
                is Resource.Success -> {
                    println(it.data?.indeksBerkelanjutan)
                }
                else -> println("erorr")
            }
        }
    }

    private fun initClick() {
        with(binding){
            btnIsiKuisioner.setOnClickListener { findNavController().navigate(R.id.action_homeFragment_to_firstQuestionerFragment) }
        }
    }
}