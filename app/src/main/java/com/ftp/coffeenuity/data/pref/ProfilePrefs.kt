package com.ftp.coffeenuity.data.pref

import androidx.annotation.Keep
import com.chibatching.kotpref.KotprefModel

@Keep
object ProfilePrefs: KotprefModel() {

    var fullname by stringPref("")
    var usia by stringPref("")
    var alamat by stringPref("")
    var email by stringPref("")
    var jwt_token by stringPref("")
    var jumlahTenagaKerja by stringPref("")
    var sifatUsaha by stringPref("")
    var jenisKelamin by stringPref("")
    var first_time by booleanPref(true)
    var role by stringPref("")
    var idFirebase by stringPref("")

}