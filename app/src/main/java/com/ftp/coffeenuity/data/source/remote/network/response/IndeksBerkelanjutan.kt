package com.ftp.coffeenuity.data.source.remote.network.response


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class IndeksBerkelanjutan(
    @SerializedName("ekonomi")
    var ekonomi: Ekonomi,
    @SerializedName("lingkungan")
    var lingkungan: Lingkungan,
    @SerializedName("sosial")
    var sosial: Sosial
) : Parcelable