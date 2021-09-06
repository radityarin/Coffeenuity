package com.ftp.coffeenuity.domain.usecases.fuzzy

import com.ftp.coffeenuity.data.source.remote.network.request.PetaniRequest
import com.ftp.coffeenuity.data.source.remote.network.response.PetaniResponse
import com.ftp.coffeenuity.data.utils.Resource
import com.ftp.coffeenuity.domain.model.User
import com.ftp.coffeenuity.domain.repositories.AppRepository
import com.google.firebase.auth.AuthResult
import kotlinx.coroutines.flow.Flow

class FuzzyAHPInteractor(private val repository: AppRepository) : FuzzyAHPUseCase {

    override fun getIndeksBerkelanjutanPetani(petaniRequest: PetaniRequest): Flow<Resource<PetaniResponse>> =
        repository.getIndeksKeberlanjutanPetani(petaniRequest)

}