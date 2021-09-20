package com.ftp.coffeenuity.data.source.remote.network.response


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Ekonomi(
    @SerializedName("indeks_berkelanjutan")
    var indeksBerkelanjutan: Double = 0.0,
    @SerializedName("kategori")
    var kategori: String = ""
) : Parcelable