package com.ftp.coffeenuity.data.source.remote.network

import com.ftp.coffeenuity.data.source.remote.network.request.AHPRequest
import com.ftp.coffeenuity.data.source.remote.network.response.AHPResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiServiceFuzzyAHP {

    @POST("petani")
    suspend fun getIndeksKeberlanjutanPetani(
        @Body AHPRequest : AHPRequest
    ): AHPResponse

}