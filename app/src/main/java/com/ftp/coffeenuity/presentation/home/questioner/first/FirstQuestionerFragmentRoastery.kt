package com.ftp.coffeenuity.presentation.home.questioner.first

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.ftp.coffeenuity.data.pref.ProfilePrefs
import com.ftp.coffeenuity.databinding.FragmentFirstQuestionerRoasterBinding
import com.ftp.coffeenuity.domain.model.roastery.RoasteryFirstQuestioner
import com.ftp.coffeenuity.presentation.home.questioner.third.ThirdQuestionerFragmentDirections
import com.ftp.coffeenuity.utils.Constants

class FirstQuestionerFragmentRoastery : Fragment() {

    private var _binding: FragmentFirstQuestionerRoasterBinding? = null
    private val binding get() = _binding!!
    private val args: FirstQuestionerFragmentRoasteryArgs by navArgs()

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
        initDetail()
    }

    private fun initDetail() {
        val questioner = args.questionerRoastery
        if (questioner != null) {
            with(binding) {
                editText1.setText(questioner.firstQuestioner.editText1)
                editText2.setText(questioner.firstQuestioner.editText2)
                editText3.setText(questioner.firstQuestioner.editText3)
                editText4.setText(questioner.firstQuestioner.editText4)
                editText5.setText(questioner.firstQuestioner.editText5)
                editText6.setText(questioner.firstQuestioner.editText6)
                editText7.setText(questioner.firstQuestioner.editText7)
                editText8.setText(questioner.firstQuestioner.editText8)
                editText9.setText(questioner.firstQuestioner.editText9)
                editText10.setText(questioner.firstQuestioner.editText10)
                editText11.setText(questioner.firstQuestioner.editText11)
                editText12.setText(questioner.firstQuestioner.editText12)
                editText13.setText(questioner.firstQuestioner.editText13)
                editText14.setText(questioner.firstQuestioner.editText14)
                editText15.setText(questioner.firstQuestioner.editText15)
                editText16.setText(questioner.firstQuestioner.editText16)
                editText17.setText(questioner.firstQuestioner.editText17)
                editText18.setText(questioner.firstQuestioner.editText18)
                editText19.setText(questioner.firstQuestioner.editText19)
                editText20.setText(questioner.firstQuestioner.editText20)
                editText21.setText(questioner.firstQuestioner.editText21)
                editText22.setText(questioner.firstQuestioner.editText22)
                disableEditText(getListOfEditText())
            }
        }
    }

    private fun FragmentFirstQuestionerRoasterBinding.getListOfEditText() =
        listOf(
            editText1,
            editText2,
            editText3,
            editText4,
            editText5,
            editText6,
            editText7,
            editText8,
            editText9,
            editText10,
            editText11,
            editText12,
            editText13,
            editText14,
            editText15,
            editText16,
            editText17,
            editText18,
            editText19,
            editText20,
            editText21,
            editText22
        )

    private fun initClick() {
        with(binding) {
            btnNext.setOnClickListener {
                if (args.questionerRoastery==null) {
                    goToSecondQuestioner()
                } else {
                    straightToResult()
                }
            }
        }
    }

    private fun FragmentFirstQuestionerRoasterBinding.goToSecondQuestioner() {
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
                tengkulak = null,
                questionerRoastery = args.questionerRoastery
            )
        findNavController().navigate(action)
    }


    private fun straightToResult() {
        val ahpResponse = args.questionerRoastery?.ahpResponse
        val action =
            ahpResponse?.let {
                FirstQuestionerFragmentRoasteryDirections.actionFirstQuestionerFragmentRoasteryToResultFragment(
                    it
                )
            }
        if (action != null) {
            findNavController().navigate(action)
        }

    }

    private fun disableEditText(listEditText : List<EditText>){
        listEditText.forEach {
            it.isEnabled = false
        }
    }

    private fun disableCheckBox(listCheckBox : List<CheckBox>){
        listCheckBox.forEach {
            it.isEnabled = false
        }
    }
}