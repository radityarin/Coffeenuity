package com.ftp.coffeenuity.domain.model

import com.ftp.coffeenuity.data.source.remote.network.response.AHPResponse
import com.ftp.coffeenuity.domain.model.petani.PetaniFirstQuestioner

data class QuestionerPetani(
    var idQuestioner: String = "",
    var idUser: String = "",
    var date: String = "",
    var firstQuestioner: PetaniFirstQuestioner = PetaniFirstQuestioner(),
    var ahpRequest: String = "",
    var ahpResponse: AHPResponse = AHPResponse()
)
