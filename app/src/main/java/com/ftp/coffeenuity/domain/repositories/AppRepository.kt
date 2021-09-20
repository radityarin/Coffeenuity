package com.ftp.coffeenuity.domain.repositories

import com.ftp.coffeenuity.data.source.remote.network.request.AHPRequest
import com.ftp.coffeenuity.data.source.remote.network.response.AHPResponse
import com.ftp.coffeenuity.data.utils.Resource
import com.ftp.coffeenuity.domain.model.QuestionerPetani
import com.ftp.coffeenuity.domain.model.QuestionerRoastery
import com.ftp.coffeenuity.domain.model.QuestionerTengkulak
import com.ftp.coffeenuity.domain.model.User
import com.google.firebase.auth.AuthResult
import kotlinx.coroutines.flow.Flow

interface AppRepository {

    fun registerUser(email: String, password: String): Flow<Resource<AuthResult>>
    fun loginUser(email: String, password: String): Flow<Resource<AuthResult>>
    fun addUsers(user: User): Flow<Resource<Boolean>>
    fun getIndeksKeberlanjutanPetani(AHPRequest: AHPRequest): Flow<Resource<AHPResponse>>
    fun getUserWithIDUser(idUser: String): Flow<Resource<User>>
    fun addQuestionerPetani(questioner: QuestionerPetani): Flow<Resource<Boolean>>
    fun addQuestionerTengkulak(questioner: QuestionerTengkulak): Flow<Resource<Boolean>>
    fun addQuestionerRoastery(questioner: QuestionerRoastery): Flow<Resource<Boolean>>
    fun getAllQuestionerPetani(): Flow<Resource<List<QuestionerPetani>>>
    fun getAllQuestionerRoastery(): Flow<Resource<List<QuestionerRoastery>>>
    fun getAllQuestionerTengkulak(): Flow<Resource<List<QuestionerTengkulak>>>
    fun getListQuestionerPetaniWithSpecificID(idUser: String): Flow<Resource<List<QuestionerPetani>>>
    fun getListQuestionerRoasteryWithSpecificID(idUser: String): Flow<Resource<List<QuestionerRoastery>>>
    fun getListQuestionerTengkulakWithSpecificID(idUser: String): Flow<Resource<List<QuestionerTengkulak>>>

}