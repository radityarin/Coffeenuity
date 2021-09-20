package com.ftp.coffeenuity.domain.model

import com.ftp.coffeenuity.data.source.remote.network.response.AHPResponse
import com.ftp.coffeenuity.domain.model.tengkulak.TengkulakFirstQuestioner

data class QuestionerTengkulak(
    var idQuestioner: String = "",
    var idUser: String = "",
    var date: String = "",
    var firstQuestioner: TengkulakFirstQuestioner = TengkulakFirstQuestioner(),
    var ahpRequest: String = "",
    var ahpResponse: AHPResponse = AHPResponse()
)
