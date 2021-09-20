package com.ftp.coffeenuity.presentation.admin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import com.ftp.coffeenuity.R
import com.ftp.coffeenuity.adapter.QuestionerHistoryPetaniAdapter
import com.ftp.coffeenuity.adapter.QuestionerHistoryRoasteryAdapter
import com.ftp.coffeenuity.adapter.QuestionerHistoryTengkulakAdapter
import com.ftp.coffeenuity.data.utils.Resource
import com.ftp.coffeenuity.databinding.ActivityAdminMainBinding
import com.ftp.coffeenuity.databinding.ActivityMainBinding
import com.ftp.coffeenuity.databinding.FragmentAdminHomeBinding
import com.ftp.coffeenuity.presentation.QuestionerViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class AdminMainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAdminMainBinding
    private lateinit var questionerHistoryPetaniAdapter: QuestionerHistoryPetaniAdapter
    private lateinit var questionerHistoryRoasteryAdapter: QuestionerHistoryRoasteryAdapter
    private lateinit var questionerHistoryTengkulakAdapter: QuestionerHistoryTengkulakAdapter
    private val questionerViewModel: QuestionerViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdminMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initClick()
        initView()
        setupAdapter()
        observe()
    }

    private fun observe() {
        questionerViewModel.getAllQuestionerPetani()
            .observe(this) {
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
            .observe(this) {
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
            .observe(this) {
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