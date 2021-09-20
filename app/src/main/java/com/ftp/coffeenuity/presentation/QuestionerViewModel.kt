package com.ftp.coffeenuity.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.ftp.coffeenuity.domain.model.QuestionerPetani
import com.ftp.coffeenuity.domain.model.QuestionerRoastery
import com.ftp.coffeenuity.domain.model.QuestionerTengkulak
import com.ftp.coffeenuity.domain.usecases.questioner.QuestionerUseCase

class QuestionerViewModel(
    private val questionerUseCase: QuestionerUseCase
) : ViewModel() {

    fun addQuestionerPetani(questionerPetani: QuestionerPetani) =
        questionerUseCase.addQuestionerPetani(questionerPetani = questionerPetani).asLiveData()

    fun addQuestionerTengkulak(questionerTengkulak: QuestionerTengkulak) =
        questionerUseCase.addQuestionerTengkulak(questionerTengkulak = questionerTengkulak)
            .asLiveData()

    fun addQuestionerRoastery(questionerRoastery: QuestionerRoastery) =
        questionerUseCase.addQuestionerRoastery(questionerRoastery = questionerRoastery)
            .asLiveData()

    fun getAllQuestionerPetani() = questionerUseCase.getAllQuestionerPetani().asLiveData()
    fun getAllQuestionerTengkulak() = questionerUseCase.getAllQuestionerTengkulak().asLiveData()
    fun getAllQuestionerRoastery() = questionerUseCase.getAllQuestionerRoastery().asLiveData()
    fun getListQuestionerPetaniWithSpecificID(idUser: String) =
        questionerUseCase.getAllQuestionerPetani().asLiveData()

    fun getListQuestionerTengkulakWithSpecificID(idUser: String) =
        questionerUseCase.getListQuestionerTengkulakWithSpecificID(idUser).asLiveData()

    fun getListQuestionerRoasteryWithSpecificID(idUser: String) =
        questionerUseCase.getListQuestionerRoasteryWithSpecificID(idUser).asLiveData()

}
