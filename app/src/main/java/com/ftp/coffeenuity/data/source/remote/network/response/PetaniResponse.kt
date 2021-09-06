package com.ftp.coffeenuity.data.source.remote.network.response


import com.google.gson.annotations.SerializedName

data class PetaniResponse(
    @SerializedName("data")
    var indeksBerkelanjutan: IndeksBerkelanjutan,
    @SerializedName("message")
    var message: String,
    @SerializedName("success")
    var success: Boolean
)