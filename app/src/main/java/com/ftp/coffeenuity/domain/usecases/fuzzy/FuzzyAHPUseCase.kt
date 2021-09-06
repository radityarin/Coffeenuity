package com.ftp.coffeenuity.domain.usecases.fuzzy

import com.ftp.coffeenuity.data.source.remote.network.request.PetaniRequest
import com.ftp.coffeenuity.data.source.remote.network.response.PetaniResponse
import com.ftp.coffeenuity.data.utils.Resource
import com.ftp.coffeenuity.domain.model.User
import com.google.firebase.auth.AuthResult
import kotlinx.coroutines.flow.Flow

interface FuzzyAHPUseCase {
    fun getIndeksBerkelanjutanPetani(petaniRequest: PetaniRequest): Flow<Resource<PetaniResponse>>
}