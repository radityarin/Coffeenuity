package com.ftp.coffeenuity.data.source.remote.network.response


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Sosial(
    @SerializedName("indeks_berkelanjutan")
    var indeksBerkelanjutan: Double,
    @SerializedName("kategori")
    var kategori: String
) : Parcelable