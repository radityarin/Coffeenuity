package com.ftp.coffeenuity.data.source

import com.ftp.coffeenuity.data.source.remote.RemoteDataSource
import com.ftp.coffeenuity.data.source.remote.network.request.AHPRequest
import com.ftp.coffeenuity.data.source.remote.network.response.AHPResponse
import com.ftp.coffeenuity.data.utils.Resource
import com.ftp.coffeenuity.domain.model.QuestionerPetani
import com.ftp.coffeenuity.domain.model.QuestionerRoastery
import com.ftp.coffeenuity.domain.model.QuestionerTengkulak
import com.ftp.coffeenuity.domain.model.User
import com.ftp.coffeenuity.domain.repositories.AppRepository
import com.google.firebase.auth.AuthResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow

class AppRepositoryImpl(
    private val remoteDataSource: RemoteDataSource,
) : AppRepository {

    override fun loginUser(email: String, password: String): Flow<Resource<AuthResult>> =
        remoteDataSource.loginUser(email, password)

    override fun registerUser(email: String, password: String): Flow<Resource<AuthResult>> =
        remoteDataSource.registerUser(email, password)

    override fun addUsers(user: User): Flow<Resource<Boolean>> = remoteDataSource.addUser(user)

    override fun getUserWithIDUser(idUser: String): Flow<Resource<User>> =
        remoteDataSource.getUserWithIDUser(idUser = idUser)

    override fun getIndeksKeberlanjutanPetani(AHPRequest: AHPRequest): Flow<Resource<AHPResponse>> =
        flow {
            emit(Resource.Loading())
            val apiResponse = remoteDataSource.getIndeksKeberlanjutanPetani(AHPRequest).first()
            emit(Resource.Success(apiResponse))
        }

    override fun addQuestionerPetani(questioner: QuestionerPetani) =
        remoteDataSource.addQuestionerPetani(questioner)

    override fun addQuestionerTengkulak(questioner: QuestionerTengkulak) =
        remoteDataSource.addQuestionerTengkulak(questioner)

    override fun addQuestionerRoastery(questioner: QuestionerRoastery) =
        remoteDataSource.addQuestionerRoastery(questioner)

    override fun getAllQuestionerPetani() = remoteDataSource.getAllQuestionerPetani()

    override fun getAllQuestionerRoastery() = remoteDataSource.getAllQuestionerRoastery()

    override fun getAllQuestionerTengkulak() = remoteDataSource.getAllQuestionerTengkulak()

    override fun getListQuestionerPetaniWithSpecificID(idUser: String) =
        remoteDataSource.getListQuestionerPetaniWithSpecificID(idUser)

    override fun getListQuestionerRoasteryWithSpecificID(idUser: String) =
        remoteDataSource.getListQuestionerRoasteryWithSpecificID(idUser)

    override fun getListQuestionerTengkulakWithSpecificID(idUser: String) =
        remoteDataSource.getListQuestionerTengkulakWithSpecificID(idUser)

}
