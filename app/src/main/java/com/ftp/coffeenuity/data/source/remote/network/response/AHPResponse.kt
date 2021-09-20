package com.ftp.coffeenuity.data.source.remote.network.response


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class AHPResponse(
    @SerializedName("data")
    var indeksBerkelanjutan: IndeksBerkelanjutan = IndeksBerkelanjutan(),
    @SerializedName("message")
    var message: String = "",
    @SerializedName("success")
    var success: Boolean = false
) : Parcelable