package com.ftp.coffeenuity.domain.usecases.questioner

import com.ftp.coffeenuity.data.utils.Resource
import com.ftp.coffeenuity.domain.model.QuestionerPetani
import com.ftp.coffeenuity.domain.model.QuestionerRoastery
import com.ftp.coffeenuity.domain.model.QuestionerTengkulak
import kotlinx.coroutines.flow.Flow

interface QuestionerUseCase {
    fun addQuestionerPetani(questionerPetani: QuestionerPetani): Flow<Resource<Boolean>>
    fun addQuestionerTengkulak(questionerTengkulak: QuestionerTengkulak): Flow<Resource<Boolean>>
    fun addQuestionerRoastery(questionerRoastery: QuestionerRoastery): Flow<Resource<Boolean>>
    fun getAllQuestionerPetani(): Flow<Resource<List<QuestionerPetani>>>
    fun getAllQuestionerTengkulak(): Flow<Resource<List<QuestionerTengkulak>>>
    fun getAllQuestionerRoastery(): Flow<Resource<List<QuestionerRoastery>>>
    fun getListQuestionerPetaniWithSpecificID(idUser: String): Flow<Resource<List<QuestionerPetani>>>
    fun getListQuestionerTengkulakWithSpecificID(idUser: String): Flow<Resource<List<QuestionerTengkulak>>>
    fun getListQuestionerRoasteryWithSpecificID(idUser: String): Flow<Resource<List<QuestionerRoastery>>>
}