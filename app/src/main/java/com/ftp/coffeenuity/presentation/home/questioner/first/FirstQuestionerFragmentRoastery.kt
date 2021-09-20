package com.ftp.coffeenuity.presentation.home.questioner.first

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ftp.coffeenuity.data.pref.ProfilePrefs
import com.ftp.coffeenuity.databinding.FragmentFirstQuestionerRoasterBinding
import com.ftp.coffeenuity.domain.model.roastery.RoasteryFirstQuestioner
import com.ftp.coffeenuity.utils.Constants

class FirstQuestionerFragmentRoastery : Fragment() {

    private var _binding: FragmentFirstQuestionerRoasterBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstQuestionerRoasterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClick()
    }

    private fun initClick() {
        with(binding) {
            btnNext.setOnClickListener {
                val roasteryFirstQuestioner = RoasteryFirstQuestioner(
                    ProfilePrefs.idFirebase,
                    editText1.text.toString(),
                    editText2.text.toString(),
                    editText3.text.toString(),
                    editText4.text.toString(),
                    editText5.text.toString(),
                    editText6.text.toString(),
                    editText7.text.toString(),
                    editText8.text.toString(),
                    editText9.text.toString(),
                    editText10.text.toString(),
                    editText11.text.toString(),
                    editText12.text.toString(),
                    editText13.text.toString(),
                    editText14.text.toString(),
                    editText15.text.toString(),
                    editText16.text.toString(),
                    editText17.text.toString(),
                    editText18.text.toString(),
                    editText19.text.toString(),
                    editText20.text.toString(),
                    editText21.text.toString(),
                    editText22.text.toString()
                )
                val action =
                    FirstQuestionerFragmentRoasteryDirections.actionFirstQuestionerFragmentRoasteryToSecondQuestionerFragment(
                        Constants.ROASTERY,
                        roastery = roasteryFirstQuestioner,
                        petani = null,
                        tengkulak = null
                    )
                findNavController().navigate(action)
            }
        }
    }
}