package com.ftp.coffeenuity.domain.usecases.auth

import com.ftp.coffeenuity.data.utils.Resource
import com.ftp.coffeenuity.domain.model.User
import com.ftp.coffeenuity.domain.repositories.AppRepository
import com.google.firebase.auth.AuthResult
import kotlinx.coroutines.flow.Flow

class AuthInteractor(private val repository: AppRepository) : AuthUseCase {

    override fun login(email: String, password: String): Flow<Resource<AuthResult>> =
        repository.loginUser(email, password)

    override fun register(email: String, password: String): Flow<Resource<AuthResult>> =
        repository.registerUser(email, password)

    override fun addUser(user: User): Flow<Resource<Boolean>> =
        repository.addUsers(user)
}