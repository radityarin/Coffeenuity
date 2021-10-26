package com.ftp.coffeenuity.domain.model

import android.os.Parcelable
import com.ftp.coffeenuity.data.source.remote.network.response.AHPResponse
import com.ftp.coffeenuity.domain.model.tengkulak.TengkulakFirstQuestioner
import kotlinx.parcelize.Parcelize

@Parcelize
data class QuestionerTengkulak(
    var idQuestioner: String = "",
    var idUser: String = "",
    var date: String = "",
    var firstQuestioner: TengkulakFirstQuestioner = TengkulakFirstQuestioner(),
    var ahpRequest: String = "",
    var ahpResponse: AHPResponse = AHPResponse()
) : Parcelable
