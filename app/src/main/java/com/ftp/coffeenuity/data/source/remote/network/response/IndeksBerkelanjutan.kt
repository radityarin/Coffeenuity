package com.ftp.coffeenuity.data.source.remote.network.response


import com.google.gson.annotations.SerializedName

data class IndeksBerkelanjutan(
    @SerializedName("ekonomi")
    var ekonomi: Ekonomi,
    @SerializedName("lingkungan")
    var lingkungan: Lingkungan,
    @SerializedName("sosial")
    var sosial: Sosial
)