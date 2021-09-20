package com.ftp.coffeenuity.presentation.admin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ftp.coffeenuity.adapter.QuestionerHistoryPetaniAdapter
import com.ftp.coffeenuity.adapter.QuestionerHistoryRoasteryAdapter
import com.ftp.coffeenuity.adapter.QuestionerHistoryTengkulakAdapter
import com.ftp.coffeenuity.data.utils.Resource
import com.ftp.coffeenuity.databinding.FragmentAdminHomeBinding
import com.ftp.coffeenuity.presentation.QuestionerViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class AdminHomeFragment : Fragment() {

    private var _binding: FragmentAdminHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var questionerHistoryPetaniAdapter: QuestionerHistoryPetaniAdapter
    private lateinit var questionerHistoryRoasteryAdapter: QuestionerHistoryRoasteryAdapter
    private lateinit var questionerHistoryTengkulakAdapter: QuestionerHistoryTengkulakAdapter
    private val questionerViewModel: QuestionerViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAdminHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClick()
        initView()
        setupAdapter()
        observe()
    }

    private fun observe() {
        questionerViewModel.getAllQuestionerPetani()
            .observe(viewLifecycleOwner) {
                when (it) {
                    is Resource.Loading -> {
                    }
                    is Resource.Success -> {
                        it.data?.let { it1 -> questionerHistoryPetaniAdapter.submitList(it1) }
                    }
                    is Resource.Error -> {
                        println(it.message)
                    }
                    else -> println("Error")
                }
            }
        questionerViewModel.getAllQuestionerRoastery()
            .observe(viewLifecycleOwner) {
                when (it) {
                    is Resource.Loading -> {
                    }
                    is Resource.Success -> {
                        it.data?.let { it1 -> questionerHistoryRoasteryAdapter.submitList(it1) }
                    }
                    is Resource.Error -> {
                        println(it.message)
                    }
                    else -> println("Error")
                }
            }
        questionerViewModel.getAllQuestionerTengkulak()
            .observe(viewLifecycleOwner) {
                when (it) {
                    is Resource.Loading -> {
                    }
                    is Resource.Success -> {
                        it.data?.let { it1 -> questionerHistoryTengkulakAdapter.submitList(it1) }
                    }
                    is Resource.Error -> {
                        println(it.message)
                    }
                    else -> println("Error")
                }
            }

    }

    private fun setupAdapter() {
        questionerHistoryPetaniAdapter = QuestionerHistoryPetaniAdapter()
        binding.rvHistoryPetani.adapter = questionerHistoryPetaniAdapter
        questionerHistoryRoasteryAdapter = QuestionerHistoryRoasteryAdapter()
        binding.rvHistoryRoastery.adapter = questionerHistoryRoasteryAdapter
        questionerHistoryTengkulakAdapter = QuestionerHistoryTengkulakAdapter()
        binding.rvHistoryTengkulak.adapter = questionerHistoryTengkulakAdapter
    }

    private fun initView() {

    }

    private fun initClick() {

    }
}