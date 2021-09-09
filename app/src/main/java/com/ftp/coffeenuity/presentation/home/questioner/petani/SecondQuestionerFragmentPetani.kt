package com.ftp.coffeenuity.presentation.home.questioner.petani

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ftp.coffeenuity.adapter.QuestionRangeAdapter
import com.ftp.coffeenuity.data.pref.ProfilePrefs
import com.ftp.coffeenuity.data.source.remote.network.request.PetaniRequest
import com.ftp.coffeenuity.data.staticdata.Questioner.listEkonomi
import com.ftp.coffeenuity.data.staticdata.Questioner.listEkonomiPetani
import com.ftp.coffeenuity.data.staticdata.Questioner.listLingkungan
import com.ftp.coffeenuity.data.staticdata.Questioner.listLingkunganPetani
import com.ftp.coffeenuity.data.staticdata.Questioner.listSosial
import com.ftp.coffeenuity.data.staticdata.Questioner.listSosialPetani
import com.ftp.coffeenuity.data.staticdata.Questioner.listSubKriteria
import com.ftp.coffeenuity.data.utils.Resource
import com.ftp.coffeenuity.databinding.FragmentSecondQuestionerPetaniBinding
import com.ftp.coffeenuity.presentation.auth.FuzzyViewModel
import com.ftp.coffeenuity.utils.Constants
import com.ftp.coffeenuity.utils.UtilsView.snackErrorText
import org.koin.android.viewmodel.ext.android.viewModel

class SecondQuestionerFragmentPetani : Fragment() {

    private var _binding: FragmentSecondQuestionerPetaniBinding? = null
    private val binding get() = _binding!!
    private lateinit var subKriteriaAdapter: QuestionRangeAdapter
    private lateinit var ekonomiAdapter: QuestionRangeAdapter
    private lateinit var sosialAdapter: QuestionRangeAdapter
    private lateinit var lingkunganAdapter: QuestionRangeAdapter
    private val fuzzyViewModel: FuzzyViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondQuestionerPetaniBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClick()
        setupAdapter()
    }

    private fun setupAdapter() {
        subKriteriaAdapter = QuestionRangeAdapter()
        ekonomiAdapter = QuestionRangeAdapter()
        sosialAdapter = QuestionRangeAdapter()
        lingkunganAdapter = QuestionRangeAdapter()
        subKriteriaAdapter.submitList(listSubKriteria)
        when (ProfilePrefs.role) {
            Constants.PETANI -> {
                ekonomiAdapter.submitList(listEkonomiPetani)
                sosialAdapter.submitList(listSosialPetani)
                lingkunganAdapter.submitList(listLingkunganPetani)
            }
            else -> {
                ekonomiAdapter.submitList(listEkonomi)
                sosialAdapter.submitList(listSosial)
                lingkunganAdapter.submitList(listLingkungan)
            }
        }
        with(binding) {
            rvGoalPenentuan.adapter = subKriteriaAdapter
            rvElemenVariabelEkonomi.adapter = ekonomiAdapter
            rvElemenVariabelSosial.adapter = sosialAdapter
            rvElemenVariabelLingkungan.adapter = lingkunganAdapter
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
        var check = false
        if (!subKriteriaAdapter.getData().map { it?.range }.contains(0) && !ekonomiAdapter.getData()
                .map { it?.range }.contains(0) && !sosialAdapter.getData().map { it?.range }
                .contains(0) && !lingkunganAdapter.getData().map { it?.range }.contains(0)
        ) {
            check = true
        } else {
            binding.btnNext.snackErrorText("Isi semua kuisioner terlebih dahulu")
        }
        return check
    }

    private fun letsGo() {
        val rangeSubKriteria = 2
        val rangeEkonomi = 5
        val rangeSosial = 7
        val rangeLingkungan = 3

        val skalaKriteriaEkonomi = listOf(3, 2, 5, 4, 4, 3)
        val skalaKriteriaSosial = listOf(3, 3, 4, 5, 4, 4, 3, 5)
        val skalaKriteriaLingkungan = listOf(3, 5, 3, 4)

        val subKriteriaData = subKriteriaAdapter.getData().map { it?.range }
        val ekonomiData = ekonomiAdapter.getData().map { it?.range }
        val sosialData = sosialAdapter.getData().map { it?.range }
        val lingkunganData = lingkunganAdapter.getData().map { it?.range }
        val testPetaniSubKriteria = convert(subKriteriaData, rangeSubKriteria)
        val testPetaniEkonomi = convert(ekonomiData, rangeEkonomi)
        val testPetaniSosial = convert(sosialData, rangeSosial)
        val testPetaniLingkungan = convert(lingkunganData, rangeLingkungan)

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
                    binding.btnNext.showLoading()
                }
                is Resource.Success -> {
                    val action = it.data?.let { it1 ->
                        SecondQuestionerFragmentPetaniDirections.actionSecondQuestionerFragmentToResultFragment(
                            it1
                        )
                    }
                    if (action != null) {
                        findNavController().navigate(action)
                    }
                }
                else -> println("Error")
            }
        }
    }

    private fun convert(allData: List<Int?>, range: Int): List<List<Int>> {
        val newListOfList = mutableListOf<List<Int>>()
        var index = 0
        var pengurang = 0
        for (n in 0..range) {
            val listPerRow = mutableListOf<Int>()
            listPerRow.add(1)
            for (i in 0 until range - pengurang) {
                allData[index]?.let { listPerRow.add(it) }
                index++
            }
            pengurang++
            newListOfList.add(listPerRow)
        }
        return newListOfList
    }
}