package com.ftp.coffeenuity.presentation.home.questioner.petani

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.ftp.coffeenuity.R
import com.ftp.coffeenuity.data.pref.ProfilePrefs
import com.ftp.coffeenuity.databinding.FragmentFirstQuestionerPetaniBinding
import com.ftp.coffeenuity.databinding.FragmentHomeBinding
import com.ftp.coffeenuity.domain.model.petani.PetaniFirstQuestioner
import com.ftp.coffeenuity.presentation.auth.FuzzyViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class FirstQuestionerFragmentPetani : Fragment() {

    private var _binding: FragmentFirstQuestionerPetaniBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstQuestionerPetaniBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClick()
    }

    private fun initClick() {
        with(binding){
            btnNext.setOnClickListener {
                val petaniFirstQuestionerPetani = PetaniFirstQuestioner(
                    ProfilePrefs.idFirebase,
                    editText1.text.toString(),
                    editText2.text.toString(),
                    editText3.text.toString(),
                    editText4.text.toString(),
                    editText5.text.toString(),
                    editText6.text.toString(),
                    editText7.text.toString(),
                    listOf(cb1.isChecked,cb2.isChecked,cb3.isChecked,cb4.isChecked,cb5.isChecked,cb6.isChecked,cb7.isChecked),
                    editText9.text.toString(),
                    editText10.text.toString(),
                    editText11.text.toString(),
                    editText12.text.toString(),
                    editText13.text.toString(),
                    editText14.text.toString(),
                    editText15.text.toString(),
                    editText16.text.toString(),
                    editText17.text.toString(),
                )
                val action = FirstQuestionerFragmentPetaniDirections.actionFirstQuestionerFragmentToSecondQuestionerFragmentPetani(petaniFirstQuestionerPetani)
                findNavController().navigate(action)
            }
        }
    }
}