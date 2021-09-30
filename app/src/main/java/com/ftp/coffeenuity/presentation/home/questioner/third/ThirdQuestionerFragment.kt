package com.ftp.coffeenuity.presentation.home.questioner.third

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.ftp.coffeenuity.R
import com.ftp.coffeenuity.adapter.QuestionerContinuityRangeAdapter
import com.ftp.coffeenuity.data.pref.ProfilePrefs
import com.ftp.coffeenuity.data.source.remote.network.request.AHPRequest
import com.ftp.coffeenuity.data.source.remote.network.response.AHPResponse
import com.ftp.coffeenuity.data.staticdata.Questioner.listEkonomiKeberlanjutan
import com.ftp.coffeenuity.data.staticdata.Questioner.listEkonomiKeberlanjutanPetani
import com.ftp.coffeenuity.data.staticdata.Questioner.listLingkunganKeberlanjutan
import com.ftp.coffeenuity.data.staticdata.Questioner.listLingkunganKeberlanjutanPetani
import com.ftp.coffeenuity.data.staticdata.Questioner.listSosialKeberlanjutan
import com.ftp.coffeenuity.data.staticdata.Questioner.listSosialKeberlanjutanPetani
import com.ftp.coffeenuity.data.utils.Resource
import com.ftp.coffeenuity.databinding.FragmentSecondQuestionerBinding
import com.ftp.coffeenuity.databinding.FragmentThirdQuestionerBinding
import com.ftp.coffeenuity.domain.model.QuestionerPetani
import com.ftp.coffeenuity.domain.model.QuestionerRoastery
import com.ftp.coffeenuity.domain.model.QuestionerTengkulak
import com.ftp.coffeenuity.presentation.QuestionerViewModel
import com.ftp.coffeenuity.presentation.home.questioner.FuzzyViewModel
import com.ftp.coffeenuity.utils.Constants
import com.ftp.coffeenuity.utils.Utils
import com.ftp.coffeenuity.utils.UtilsDate
import com.ftp.coffeenuity.utils.UtilsView.snackErrorText
import com.google.gson.Gson
import org.koin.android.viewmodel.ext.android.viewModel

class ThirdQuestionerFragment : Fragment() {

    private var _binding: FragmentThirdQuestionerBinding? = null
    private val binding get() = _binding!!
    private lateinit var ekonomiContinuityAdapter: QuestionerContinuityRangeAdapter
    private lateinit var sosialContinuityAdapter: QuestionerContinuityRangeAdapter
    private lateinit var lingkunganContinuityAdapter: QuestionerContinuityRangeAdapter
    private val fuzzyViewModel: FuzzyViewModel by viewModel()
    private val questionerViewModel: QuestionerViewModel by viewModel()
    private val args: ThirdQuestionerFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentThirdQuestionerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClick()
        setupAdapter()
    }

    private fun setupAdapter() {
        ekonomiContinuityAdapter = QuestionerContinuityRangeAdapter()
        sosialContinuityAdapter = QuestionerContinuityRangeAdapter()
        lingkunganContinuityAdapter = QuestionerContinuityRangeAdapter()
        when (ProfilePrefs.role) {
            Constants.PETANI -> {
                ekonomiContinuityAdapter.submitList(listEkonomiKeberlanjutanPetani)
                sosialContinuityAdapter.submitList(listSosialKeberlanjutanPetani)
                lingkunganContinuityAdapter.submitList(listLingkunganKeberlanjutanPetani)
            }
            else -> {
                ekonomiContinuityAdapter.submitList(listEkonomiKeberlanjutan)
                sosialContinuityAdapter.submitList(listSosialKeberlanjutan)
                lingkunganContinuityAdapter.submitList(listLingkunganKeberlanjutan)
            }
        }
        with(binding) {
            rvElemenVariabelEkonomi.adapter = ekonomiContinuityAdapter
            rvElemenVariabelSosial.adapter = sosialContinuityAdapter
            rvElemenVariabelLingkungan.adapter = lingkunganContinuityAdapter
        }
    }

    private fun initClick() {
        with(binding) {
            btnNext.setOnClickListener {
                if (check()) {
                    letsGo()
                }
            }
        }
    }

    private fun check(): Boolean {
        println(ekonomiContinuityAdapter.getData().map { it.range })
        println(sosialContinuityAdapter.getData().map { it.range })
        println(lingkunganContinuityAdapter.getData().map { it.range })
        var check = false
        if (!ekonomiContinuityAdapter.getData()
                .map { it.range }.contains(0) && !sosialContinuityAdapter.getData().map { it.range }
                .contains(0) && !lingkunganContinuityAdapter.getData().map { it.range }.contains(0)
        ) {
            check = true
        } else {
            binding.btnNext.snackErrorText("Isi semua kuisioner terlebih dahulu")
        }
        return check
    }

    private fun letsGo() {
        val skalaKeberlanjutanEkonomi = ekonomiContinuityAdapter.getData().map { it.range }
        val skalaKeberlanjutanSosial = sosialContinuityAdapter.getData().map { it.range }
        val skalaKeberlanjutanLingkungan = lingkunganContinuityAdapter.getData().map { it.range }

        val ahpRequest = args.ahpRequest
        ahpRequest.skalaKriteriaEkonomi = skalaKeberlanjutanEkonomi
        ahpRequest.skalaKriteriaSosial = skalaKeberlanjutanSosial
        ahpRequest.skalaKriteriaLingkungan = skalaKeberlanjutanLingkungan

        fuzzyViewModel.getIndeksBerkelanjutanPetani(ahpRequest).observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Loading -> {
                    binding.btnNext.showLoading()
                }
                is Resource.Success -> {
                    setupQuestionerToFirebase(ahpRequest, it.data)
                }
                else -> binding.root.snackErrorText(getString(R.string.error))
            }
        }
    }

    private fun setupQuestionerToFirebase(ahpRequest: AHPRequest, data: AHPResponse?) {
        when (ProfilePrefs.role) {
            Constants.PETANI -> {
                val firstQuestioner = args.petani
                if (firstQuestioner != null && data != null) {
                    val questioner = QuestionerPetani(
                        idQuestioner = Utils.getRandomString(20),
                        idUser = ProfilePrefs.idFirebase,
                        date = UtilsDate.getCurrentDateTimeForUsersSide(),
                        firstQuestioner = firstQuestioner,
                        ahpRequest = Gson().toJson(ahpRequest),
                        ahpResponse = data
                    )
                    addQuestionerPetaniToFirebase(questioner)
                }
            }
            Constants.TENGKULAK -> {
                val firstQuestioner = args.tengkulak
                if (firstQuestioner != null && data != null) {
                    val questioner = QuestionerTengkulak(
                        idQuestioner = Utils.getRandomString(20),
                        idUser = ProfilePrefs.idFirebase,
                        date = UtilsDate.getCurrentDateTimeForUsersSide(),
                        firstQuestioner = firstQuestioner,
                        ahpRequest = Gson().toJson(ahpRequest),
                        ahpResponse = data
                    )
                    addQuestionerTengkulakToFirebase(questioner)
                }
            }
            Constants.ROASTERY -> {
                val firstQuestioner = args.roastery
                if (firstQuestioner != null && data != null) {
                    val questioner = QuestionerRoastery(
                        idQuestioner = Utils.getRandomString(20),
                        idUser = ProfilePrefs.idFirebase,
                        date = UtilsDate.getCurrentDateTimeForUsersSide(),
                        firstQuestioner = firstQuestioner,
                        ahpRequest = Gson().toJson(ahpRequest),
                        ahpResponse = data
                    )
                    addQuestionerRoasteryToFirebase(questioner)
                }
            }
            else -> {
            }
        }

    }

    private fun addQuestionerRoasteryToFirebase(questioner: QuestionerRoastery) {
        questionerViewModel.addQuestionerRoastery(questioner).observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Loading -> {
                    binding.btnNext.showLoading()
                }
                is Resource.Success -> {
                    navigateToResultFragment(questioner.ahpResponse)
                }
                is Resource.Error -> {
                    println(it.message)
                }
                else -> println("Error")
            }
        }
    }

    private fun addQuestionerTengkulakToFirebase(questioner: QuestionerTengkulak) {
        questionerViewModel.addQuestionerTengkulak(questioner).observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Loading -> {
                    binding.btnNext.showLoading()
                }
                is Resource.Success -> {
                    navigateToResultFragment(questioner.ahpResponse)
                }
                is Resource.Error -> {
                    println(it.message)
                }
                else -> println("Error")
            }
        }
    }

    private fun addQuestionerPetaniToFirebase(questioner: QuestionerPetani) {
        questionerViewModel.addQuestionerPetani(questioner).observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Loading -> {
                    binding.btnNext.showLoading()
                }
                is Resource.Success -> {
                    navigateToResultFragment(questioner.ahpResponse)
                }
                is Resource.Error -> {
                    println(it.message)
                }
                else -> println("Error")
            }
        }
    }

    private fun navigateToResultFragment(ahpResponse: AHPResponse) {
        val action =
            ThirdQuestionerFragmentDirections.actionSecondQuestionerFragmentToResultFragment(
                ahpResponse
            )
        findNavController().navigate(action)
    }

}