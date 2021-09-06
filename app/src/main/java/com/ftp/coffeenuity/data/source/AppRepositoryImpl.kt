package com.ftp.coffeenuity.data.source

import android.content.Context
import com.ftp.coffeenuity.data.source.remote.RemoteDataSource
import com.ftp.coffeenuity.data.source.remote.network.request.PetaniRequest
import com.ftp.coffeenuity.data.source.remote.network.response.PetaniResponse
import com.ftp.coffeenuity.data.utils.Resource
import com.ftp.coffeenuity.domain.model.User
import com.ftp.coffeenuity.domain.repositories.AppRepository
import com.google.firebase.auth.AuthResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow

class AppRepositoryImpl(
//    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource,
) : AppRepository {

    override fun loginUser(email: String, password: String): Flow<Resource<AuthResult>> =
        remoteDataSource.loginUser(email, password)

    override fun registerUser(email: String, password: String): Flow<Resource<AuthResult>> =
        remoteDataSource.registerUser(email, password)

    override fun addUsers(user: User): Flow<Resource<Boolean>> = remoteDataSource.addUser(user)

    override fun getIndeksKeberlanjutanPetani(petaniRequest: PetaniRequest): Flow<Resource<PetaniResponse>> =
        flow {
            emit(Resource.Loading())
            val apiResponse = remoteDataSource.getIndeksKeberlanjutanPetani(petaniRequest).first()
            emit(Resource.Success(apiResponse))
        }
}
