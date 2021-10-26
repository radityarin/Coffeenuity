package com.ftp.coffeenuity.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ftp.coffeenuity.adapter.QuestionerHistoryPetaniAdapter
import com.ftp.coffeenuity.adapter.QuestionerHistoryRoasteryAdapter
import com.ftp.coffeenuity.adapter.QuestionerHistoryTengkulakAdapter
import com.ftp.coffeenuity.data.pref.ProfilePrefs
import com.ftp.coffeenuity.data.utils.Resource
import com.ftp.coffeenuity.databinding.FragmentHistoryBinding
import com.ftp.coffeenuity.domain.model.QuestionerPetani
import com.ftp.coffeenuity.domain.model.QuestionerRoastery
import com.ftp.coffeenuity.domain.model.QuestionerTengkulak
import com.ftp.coffeenuity.presentation.QuestionerViewModel
import com.ftp.coffeenuity.utils.Constants
import org.koin.android.viewmodel.ext.android.viewModel

class HistoryFragment : Fragment() {

    private var _binding: FragmentHistoryBinding? = null
    private val binding get() = _binding!!
    private lateinit var questionerHistoryPetaniAdapter: QuestionerHistoryPetaniAdapter
    private lateinit var questionerHistoryRoasteryAdapter: QuestionerHistoryRoasteryAdapter
    private lateinit var questionerHistoryTengkulakAdapter: QuestionerHistoryTengkulakAdapter
    private val questionerViewModel: QuestionerViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHistoryBinding.inflate(inflater, container, false)
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
        when (ProfilePrefs.role) {
            Constants.PETANI -> {
                questionerViewModel.getListQuestionerPetaniWithSpecificID(ProfilePrefs.idFirebase)
                    .observe(viewLifecycleOwner) {
                        when (it) {
                            is Resource.Loading -> {
                                binding.progressBar.visibility = View.VISIBLE
                            }
                            is Resource.Success -> {
                                binding.progressBar.visibility = View.GONE
                                it.data?.let { it1 -> questionerHistoryPetaniAdapter.submitList(it1) }
                            }
                            is Resource.Error -> {
                                binding.progressBar.visibility = View.GONE
                                println(it.message)
                            }
                            else -> println("Error")
                        }
                    }
            }
            Constants.ROASTERY -> {
                questionerViewModel.getListQuestionerRoasteryWithSpecificID(ProfilePrefs.idFirebase)
                    .observe(viewLifecycleOwner) {
                        when (it) {
                            is Resource.Loading -> {
                                binding.progressBar.visibility = View.VISIBLE
                            }
                            is Resource.Success -> {
                                binding.progressBar.visibility = View.GONE
                                it.data?.let { it1 ->
                                    questionerHistoryRoasteryAdapter.submitList(
                                        it1
                                    )
                                }
                            }
                            is Resource.Error -> {
                                binding.progressBar.visibility = View.GONE
                                println(it.message)
                            }
                            else -> println("Error")
                        }
                    }
            }
            Constants.TENGKULAK -> {
                questionerViewModel.getListQuestionerTengkulakWithSpecificID(ProfilePrefs.idFirebase)
                    .observe(viewLifecycleOwner) {
                        when (it) {
                            is Resource.Loading -> {
                                binding.progressBar.visibility = View.VISIBLE
                            }
                            is Resource.Success -> {
                                binding.progressBar.visibility = View.GONE
                                it.data?.let { it1 ->
                                    questionerHistoryTengkulakAdapter.submitList(
                                        it1
                                    )
                                }
                            }
                            is Resource.Error -> {
                                binding.progressBar.visibility = View.GONE
                                println(it.message)
                            }
                            else -> println("Error")
                        }
                    }
            }
            else -> {

            }
        }
    }

    private fun setupAdapter() {
        when (ProfilePrefs.role) {
            Constants.PETANI -> {
                questionerHistoryPetaniAdapter = QuestionerHistoryPetaniAdapter()
                questionerHistoryPetaniAdapter.setHistoryClickListener(object : QuestionerHistoryPetaniAdapter.OnHistoryClickListener{
                    override fun onItemClickListener(questionerPetani: QuestionerPetani) {
                        val action = HistoryFragmentDirections.actionHistoryFragmentToFirstQuestionerFragmentPetani(questionerPetani)
                        findNavController().navigate(action)
                    }
                })
                binding.rvHistory.adapter = questionerHistoryPetaniAdapter
            }
            Constants.ROASTERY -> {
                questionerHistoryRoasteryAdapter = QuestionerHistoryRoasteryAdapter()
                questionerHistoryRoasteryAdapter.setHistoryClickListener(object : QuestionerHistoryRoasteryAdapter.OnHistoryClickListener{
                    override fun onItemClickListener(questionerRoastery: QuestionerRoastery) {
                        val action = HistoryFragmentDirections.actionHistoryFragmentToFirstQuestionerFragmentRoastery(questionerRoastery)
                        findNavController().navigate(action)
                    }
                })
                binding.rvHistory.adapter = questionerHistoryRoasteryAdapter
            }
            Constants.TENGKULAK -> {
                questionerHistoryTengkulakAdapter = QuestionerHistoryTengkulakAdapter()
                questionerHistoryTengkulakAdapter.setHistoryClickListener(object : QuestionerHistoryTengkulakAdapter.OnHistoryClickListener{
                    override fun onItemClickListener(questionerTengkulak: QuestionerTengkulak) {
                        val action = HistoryFragmentDirections.actionHistoryFragmentToFirstQuestionerFragmentTengkulak(questionerTengkulak)
                        findNavController().navigate(action)
                    }
                })
                binding.rvHistory.adapter = questionerHistoryTengkulakAdapter
            }
            else -> {
            }
        }
    }

    private fun initView() {

    }

    private fun initClick() {

    }

}