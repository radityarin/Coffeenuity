package com.ftp.coffeenuity.domain.repositories

import com.ftp.coffeenuity.data.source.remote.network.request.PetaniRequest
import com.ftp.coffeenuity.data.source.remote.network.response.IndeksBerkelanjutan
import com.ftp.coffeenuity.data.source.remote.network.response.PetaniResponse
import com.ftp.coffeenuity.data.utils.Resource
import com.ftp.coffeenuity.domain.model.User
import com.google.firebase.auth.AuthResult
import kotlinx.coroutines.flow.Flow

interface AppRepository {

    //AUTH
    fun registerUser(email: String, password: String): Flow<Resource<AuthResult>>
    fun loginUser(email: String, password: String): Flow<Resource<AuthResult>>
    fun addUsers(user: User): Flow<Resource<Boolean>>
    fun getIndeksKeberlanjutanPetani(petaniRequest: PetaniRequest): Flow<Resource<PetaniResponse>>

}