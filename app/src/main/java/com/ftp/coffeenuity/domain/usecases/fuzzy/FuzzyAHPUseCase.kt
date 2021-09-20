package com.ftp.coffeenuity.domain.usecases.fuzzy

import com.ftp.coffeenuity.data.source.remote.network.request.AHPRequest
import com.ftp.coffeenuity.data.source.remote.network.response.AHPResponse
import com.ftp.coffeenuity.data.utils.Resource
import kotlinx.coroutines.flow.Flow

interface FuzzyAHPUseCase {
    fun getIndeksBerkelanjutanPetani(AHPRequest: AHPRequest): Flow<Resource<AHPResponse>>
}