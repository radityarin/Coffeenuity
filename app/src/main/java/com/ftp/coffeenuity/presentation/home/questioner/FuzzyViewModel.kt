package com.ftp.coffeenuity.presentation.home.questioner

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.ftp.coffeenuity.data.source.remote.network.request.AHPRequest
import com.ftp.coffeenuity.domain.usecases.fuzzy.FuzzyAHPUseCase

class FuzzyViewModel(
    private val fuzzyAHPUseCase: FuzzyAHPUseCase
) : ViewModel() {

    fun getIndeksBerkelanjutanPetani(AHPRequest: AHPRequest) =
        fuzzyAHPUseCase.getIndeksBerkelanjutanPetani(AHPRequest).asLiveData()

}
