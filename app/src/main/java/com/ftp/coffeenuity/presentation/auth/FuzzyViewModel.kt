package com.ftp.coffeenuity.presentation.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.ftp.coffeenuity.data.source.remote.network.request.PetaniRequest
import com.ftp.coffeenuity.domain.model.User
import com.ftp.coffeenuity.domain.usecases.auth.AuthUseCase
import com.ftp.coffeenuity.domain.usecases.fuzzy.FuzzyAHPUseCase

class FuzzyViewModel(
    private val fuzzyAHPUseCase: FuzzyAHPUseCase
) : ViewModel() {

    fun getIndeksBerkelanjutanPetani(petaniRequest: PetaniRequest) = fuzzyAHPUseCase.getIndeksBerkelanjutanPetani(petaniRequest).asLiveData()

}
