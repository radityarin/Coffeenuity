package com.ftp.coffeenuity.presentation.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.ftp.coffeenuity.domain.model.User
import com.ftp.coffeenuity.domain.usecases.auth.AuthUseCase

class AuthViewModel(
    private val authUseCase: AuthUseCase
) : ViewModel() {

    fun login(email: String, password: String) =
        authUseCase.login(email, password).asLiveData()

    fun register(email: String, password: String) =
        authUseCase.register(email, password).asLiveData()

    fun addUser(user: User) = authUseCase.addUser(user).asLiveData()

}
