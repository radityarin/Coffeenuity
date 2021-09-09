package com.ftp.coffeenuity.domain.model.petani

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PetaniFirstQuestioner(
    var idUser: String = "",
    var editText1: String ="",
    var editText2: String ="",
    var editText3: String ="",
    var editText4: String ="",
    var editText5: String ="",
    var editText6: String ="",
    var editText7: String ="",
    var checkBox8: List<Boolean>? = null,
    var editText9: String ="",
    var editText10: String ="",
    var editText11: String ="",
    var editText12: String ="",
    var editText13: String ="",
    var editText14: String ="",
    var editText15: String ="",
    var editText16: String ="",
    var editText17: String =""
) : Parcelable