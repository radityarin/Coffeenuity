package com.ftp.coffeenuity.data.source.remote.network

import com.ftp.coffeenuity.data.source.remote.network.request.PetaniRequest
import com.ftp.coffeenuity.data.source.remote.network.response.PetaniResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiServiceFuzzyAHP {

    @POST("petani")
    suspend fun getIndeksKeberlanjutanPetani(
        @Body petaniRequest : PetaniRequest
    ): PetaniResponse

}