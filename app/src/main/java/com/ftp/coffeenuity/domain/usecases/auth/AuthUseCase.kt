package com.ftp.coffeenuity.domain.usecases.auth

import com.ftp.coffeenuity.data.utils.Resource
import com.ftp.coffeenuity.domain.model.User
import com.google.firebase.auth.AuthResult
import kotlinx.coroutines.flow.Flow

interface AuthUseCase {
    fun addUser(user: User): Flow<Resource<Boolean>>
    fun register(email: String, password: String): Flow<Resource<AuthResult>>
    fun login(email: String, password: String): Flow<Resource<AuthResult>>
}