package com.ftp.coffeenuity.domain.usecases.fuzzy

import com.ftp.coffeenuity.data.source.remote.network.request.AHPRequest
import com.ftp.coffeenuity.data.source.remote.network.response.AHPResponse
import com.ftp.coffeenuity.data.utils.Resource
import com.ftp.coffeenuity.domain.repositories.AppRepository
import kotlinx.coroutines.flow.Flow

class FuzzyAHPInteractor(private val repository: AppRepository) : FuzzyAHPUseCase {

    override fun getIndeksBerkelanjutanPetani(AHPRequest: AHPRequest): Flow<Resource<AHPResponse>> =
        repository.getIndeksKeberlanjutanPetani(AHPRequest)

}