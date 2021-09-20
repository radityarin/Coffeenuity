package com.ftp.coffeenuity.presentation.home.questioner.first

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ftp.coffeenuity.data.pref.ProfilePrefs
import com.ftp.coffeenuity.databinding.FragmentFirstQuestionerTengkulakBinding
import com.ftp.coffeenuity.domain.model.tengkulak.TengkulakFirstQuestioner
import com.ftp.coffeenuity.utils.Constants
import com.ftp.coffeenuity.utils.Utils

class FirstQuestionerFragmentTengkulak : Fragment() {

    private var _binding: FragmentFirstQuestionerTengkulakBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstQuestionerTengkulakBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClick()
    }

    private fun initClick() {
        with(binding) {
            btnNext.setOnClickListener {
                val tengkulakFirstQuestioner = TengkulakFirstQuestioner(
                    ProfilePrefs.idFirebase,
                    editText1.text.toString(),
                    editText2.text.toString(),
                    editText3.text.toString(),
                    editText4.text.toString(),
                    editText5.text.toString(),
                    editText6.text.toString(),
                    Utils.convertToString(
                        listOf(
                            cb1.isChecked,
                            cb2.isChecked,
                            cb3.isChecked,
                            cb4.isChecked,
                            cb5.isChecked,
                            cb6.isChecked,
                            cb7.isChecked
                        )
                    ),
                    editText8.text.toString(),
                    editText9.text.toString(),
                    editText10.text.toString(),
                    editText11.text.toString(),
                    editText12.text.toString(),
                    editText13.text.toString()
                )
                val action =
                    FirstQuestionerFragmentTengkulakDirections.actionFirstQuestionerFragmentTengkulakToSecondQuestionerFragment(
                        Constants.TENGKULAK,
                        roastery = null,
                        petani = null,
                        tengkulak = tengkulakFirstQuestioner
                    )
                findNavController().navigate(action)
            }
        }
    }
}