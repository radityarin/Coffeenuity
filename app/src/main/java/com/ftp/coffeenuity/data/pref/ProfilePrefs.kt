package com.ftp.coffeenuity.data.pref

import androidx.annotation.Keep
import com.chibatching.kotpref.KotprefModel

@Keep
object ProfilePrefs: KotprefModel() {

    var id_user by stringPref("")
    var idIotUser by stringPref("")
    var username by stringPref("")
    var fullname by stringPref("")
    var email by stringPref("")
    var no_hp by stringPref("")
    var photoAvailable by booleanPref(false)
    var photo_profil by stringPref("")
    var idPhoto by stringPref("")
    var jwt_token by stringPref("")
    var first_time by booleanPref(true)
    var is_ppl by booleanPref(false)
    var location_update_time by stringPref("")
    var current_location by stringPref("")
    var current_location_full_text by stringPref("")
    var created_at by stringPref("")
    var tokenFire by stringPref("")
    var count_reward by stringPref("0")
    var role by stringPref("")
    var password by stringPref("")
    var idFirebase by stringPref("")
    var tokenFcm by stringPref("")

}