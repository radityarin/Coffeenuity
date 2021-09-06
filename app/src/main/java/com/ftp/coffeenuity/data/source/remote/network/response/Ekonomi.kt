package com.ftp.coffeenuity.data.source.remote.network.response


import com.google.gson.annotations.SerializedName

data class Ekonomi(
    @SerializedName("indeks_berkelanjutan")
    var indeksBerkelanjutan: Double,
    @SerializedName("kategori")
    var kategori: String
)