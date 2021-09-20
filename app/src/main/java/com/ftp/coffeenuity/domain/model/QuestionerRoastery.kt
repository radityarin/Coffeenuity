package com.ftp.coffeenuity.domain.model

import com.ftp.coffeenuity.data.source.remote.network.response.AHPResponse
import com.ftp.coffeenuity.domain.model.roastery.RoasteryFirstQuestioner

data class QuestionerRoastery(
    var idQuestioner: String = "",
    var idUser: String = "",
    var date: String = "",
    var firstQuestioner: RoasteryFirstQuestioner = RoasteryFirstQuestioner(),
    var ahpRequest: String = "",
    var ahpResponse: AHPResponse = AHPResponse()
)
