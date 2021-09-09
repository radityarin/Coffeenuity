package com.ftp.coffeenuity.data.source.remote.network.response


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class PetaniResponse(
    @SerializedName("data")
    var indeksBerkelanjutan: IndeksBerkelanjutan,
    @SerializedName("message")
    var message: String,
    @SerializedName("success")
    var success: Boolean
) : Parcelable