package com.ftp.coffeenuity.domain.usecases.questioner

import com.ftp.coffeenuity.data.utils.Resource
import com.ftp.coffeenuity.domain.model.QuestionerPetani
import com.ftp.coffeenuity.domain.model.QuestionerRoastery
import com.ftp.coffeenuity.domain.model.QuestionerTengkulak
import com.ftp.coffeenuity.domain.repositories.AppRepository
import kotlinx.coroutines.flow.Flow

class QuestionerInteractor(private val repository: AppRepository) : QuestionerUseCase {

    override fun addQuestionerPetani(questionerPetani: QuestionerPetani) =
        repository.addQuestionerPetani(questionerPetani)

    override fun addQuestionerTengkulak(questionerTengkulak: QuestionerTengkulak) =
        repository.addQuestionerTengkulak(questionerTengkulak)

    override fun addQuestionerRoastery(questionerRoastery: QuestionerRoastery) =
        repository.addQuestionerRoastery(questionerRoastery)

    override fun getAllQuestionerPetani(): Flow<Resource<List<QuestionerPetani>>> =
        repository.getAllQuestionerPetani()

    override fun getAllQuestionerTengkulak(): Flow<Resource<List<QuestionerTengkulak>>> =
        repository.getAllQuestionerTengkulak()

    override fun getAllQuestionerRoastery(): Flow<Resource<List<QuestionerRoastery>>> =
        repository.getAllQuestionerRoastery()

    override fun getListQuestionerPetaniWithSpecificID(idUser: String): Flow<Resource<List<QuestionerPetani>>> =
        repository.getListQuestionerPetaniWithSpecificID(idUser)

    override fun getListQuestionerTengkulakWithSpecificID(idUser: String): Flow<Resource<List<QuestionerTengkulak>>> =
        repository.getListQuestionerTengkulakWithSpecificID(idUser)

    override fun getListQuestionerRoasteryWithSpecificID(idUser: String): Flow<Resource<List<QuestionerRoastery>>> =
        repository.getListQuestionerRoasteryWithSpecificID(idUser)

}