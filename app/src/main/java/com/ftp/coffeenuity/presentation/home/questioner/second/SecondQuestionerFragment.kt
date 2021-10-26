package com.ftp.coffeenuity.presentation.home.questioner.second

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.ftp.coffeenuity.adapter.QuestionerRangeAdapter
import com.ftp.coffeenuity.data.pref.ProfilePrefs
import com.ftp.coffeenuity.data.source.remote.network.request.AHPRequest
import com.ftp.coffeenuity.data.staticdata.Questioner.listEkonomi
import com.ftp.coffeenuity.data.staticdata.Questioner.listEkonomiPetani
import com.ftp.coffeenuity.data.staticdata.Questioner.listLingkungan
import com.ftp.coffeenuity.data.staticdata.Questioner.listLingkunganPetani
import com.ftp.coffeenuity.data.staticdata.Questioner.listSosial
import com.ftp.coffeenuity.data.staticdata.Questioner.listSosialPetani
import com.ftp.coffeenuity.data.staticdata.Questioner.listSubKriteria
import com.ftp.coffeenuity.databinding.FragmentSecondQuestionerBinding
import com.ftp.coffeenuity.utils.Constants
import com.ftp.coffeenuity.utils.UtilsView.snackErrorText

class SecondQuestionerFragment : Fragment() {

    private var _binding: FragmentSecondQuestionerBinding? = null
    private val binding get() = _binding!!
    private lateinit var subKriteriaAdapter: QuestionerRangeAdapter
    private lateinit var ekonomiAdapter: QuestionerRangeAdapter
    private lateinit var sosialAdapter: QuestionerRangeAdapter
    private lateinit var lingkunganAdapter: QuestionerRangeAdapter
    private val args: SecondQuestionerFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondQuestionerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClick()
        setupAdapter()
    }

    private fun setupAdapter() {
        subKriteriaAdapter = QuestionerRangeAdapter()
        ekonomiAdapter = QuestionerRangeAdapter()
        sosialAdapter = QuestionerRangeAdapter()
        lingkunganAdapter = QuestionerRangeAdapter()
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

        val ahpRequest = AHPRequest(
            testPetaniSubKriteria = testPetaniSubKriteria,
            testPetaniEkonomi = testPetaniEkonomi,
            testPetaniSosial = testPetaniSosial,
            testPetaniLingkungan = testPetaniLingkungan,
            skalaKriteriaEkonomi = skalaKriteriaEkonomi,
            skalaKriteriaSosial = skalaKriteriaSosial,
            skalaKriteriaLingkungan = skalaKriteriaLingkungan
        )
        navigateToResultFragment(ahpRequest)
    }

    private fun navigateToResultFragment(ahpRequest: AHPRequest) {
        val action =
            SecondQuestionerFragmentDirections.actionSecondQuestionerFragmentToThirdQuestionerFragment(
                type = args.type,
                roastery = args.roastery,
                petani = args.petani,
                tengkulak = args.tengkulak,
                ahpRequest = ahpRequest
            )
        findNavController().navigate(action)
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