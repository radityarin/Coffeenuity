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
import com.ftp.coffeenuity.databinding.FragmentFirstQuestionerPetaniBinding
import com.ftp.coffeenuity.domain.model.petani.PetaniFirstQuestioner
import com.ftp.coffeenuity.presentation.home.questioner.third.ThirdQuestionerFragmentDirections
import com.ftp.coffeenuity.utils.Constants
import com.ftp.coffeenuity.utils.Utils

class FirstQuestionerFragmentPetani : Fragment() {

    private var _binding: FragmentFirstQuestionerPetaniBinding? = null
    private val binding get() = _binding!!
    private val args: FirstQuestionerFragmentPetaniArgs by navArgs()

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
        initDetail()
    }

    private fun initDetail() {
        val questioner = args.questionerPetani
        if (questioner != null) {
            with(binding) {
                editText1.setText(questioner.firstQuestioner.editText1)
                editText2.setText(questioner.firstQuestioner.editText2)
                editText3.setText(questioner.firstQuestioner.editText3)
                editText4.setText(questioner.firstQuestioner.editText4)
                editText5.setText(questioner.firstQuestioner.editText5)
                editText6.setText(questioner.firstQuestioner.editText6)
                editText7.setText(questioner.firstQuestioner.editText7)
                setCheckbox(questioner.firstQuestioner.checkBox8)
                editText9.setText(questioner.firstQuestioner.editText9)
                editText10.setText(questioner.firstQuestioner.editText10)
                editText11.setText(questioner.firstQuestioner.editText11)
                editText12.setText(questioner.firstQuestioner.editText12)
                editText13.setText(questioner.firstQuestioner.editText13)
                editText14.setText(questioner.firstQuestioner.editText14)
                editText15.setText(questioner.firstQuestioner.editText15)
                editText16.setText(questioner.firstQuestioner.editText16)
                editText17.setText(questioner.firstQuestioner.editText17)
                disableCheckBox(getListCheckBox())
                disableEditText(getListOfEditText())
            }
        }
    }

    private fun FragmentFirstQuestionerPetaniBinding.getListOfEditText() =
        listOf(
            editText1,
            editText2,
            editText3,
            editText4,
            editText5,
            editText6,
            editText7,
            editText9,
            editText10,
            editText11,
            editText12,
            editText13,
            editText14,
            editText15,
            editText16,
            editText17
        )

    private fun setCheckbox(checkBox8: String?) {
        val listBooleanString = checkBox8?.split(",")
        val listBoolean = arrayListOf<Boolean>()
        if (listBooleanString != null) {
            for (bool in listBooleanString) {
                if (bool == "true") {
                    listBoolean.add(true)
                } else {
                    listBoolean.add(false)
                }
            }
        }
        listBoolean.removeLast()
        val listCheckbox = getListCheckBox()
        listBoolean.forEachIndexed { index, b ->
            listCheckbox[index].isChecked = b
        }
    }

    private fun getListCheckBox(): List<CheckBox> {
        return listOf(
            binding.cb1,
            binding.cb2,
            binding.cb3,
            binding.cb4,
            binding.cb5,
            binding.cb6,
            binding.cb7
        )
    }

    private fun initClick() {
        with(binding) {
            btnNext.setOnClickListener {
                if (args.questionerPetani==null) {
                    goToSecondQuestioner()
                } else {
                    straightToResult()
                }
            }
        }
    }

    private fun FragmentFirstQuestionerPetaniBinding.goToSecondQuestioner() {
        val petaniFirstQuestionerPetani = PetaniFirstQuestioner(
            ProfilePrefs.idFirebase,
            editText1.text.toString(),
            editText2.text.toString(),
            editText3.text.toString(),
            editText4.text.toString(),
            editText5.text.toString(),
            editText6.text.toString(),
            editText7.text.toString(),
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
        val action =
            FirstQuestionerFragmentPetaniDirections.actionFirstQuestionerFragmentPetaniToSecondQuestionerFragment(
                Constants.PETANI,
                roastery = null,
                petani = petaniFirstQuestionerPetani,
                tengkulak = null,
                questionerPetani = args.questionerPetani
            )
        findNavController().navigate(action)
    }

    private fun straightToResult() {
        val ahpResponse = args.questionerPetani?.ahpResponse
        val action =
            ahpResponse?.let {
                FirstQuestionerFragmentPetaniDirections.actionFirstQuestionerFragmentPetaniToResultFragment(
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