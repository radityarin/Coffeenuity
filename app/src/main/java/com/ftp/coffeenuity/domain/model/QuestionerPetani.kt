package com.ftp.coffeenuity.domain.model

import android.os.Parcelable
import com.ftp.coffeenuity.data.source.remote.network.response.AHPResponse
import com.ftp.coffeenuity.domain.model.petani.PetaniFirstQuestioner
import kotlinx.parcelize.Parcelize

@Parcelize
data class QuestionerPetani(
    var idQuestioner: String = "",
    var idUser: String = "",
    var username: String = "",
    var date: String = "",
    var firstQuestioner: PetaniFirstQuestioner = PetaniFirstQuestioner(),
    var ahpRequest: String = "",
    var ahpResponse: AHPResponse = AHPResponse()
) : Parcelable
