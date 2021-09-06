package com.ftp.coffeenuity.data.source.remote.network.request


import com.google.gson.annotations.SerializedName

data class PetaniRequest(
    @SerializedName("skala_kriteria_ekonomi")
    var skalaKriteriaEkonomi: List<Int>,
    @SerializedName("skala_kriteria_lingkungan")
    var skalaKriteriaLingkungan: List<Int>,
    @SerializedName("skala_kriteria_sosial")
    var skalaKriteriaSosial: List<Int>,
    @SerializedName("test_petani_ekonomi")
    var testPetaniEkonomi: List<List<Int>>,
    @SerializedName("test_petani_lingkungan")
    var testPetaniLingkungan: List<List<Int>>,
    @SerializedName("test_petani_sosial")
    var testPetaniSosial: List<List<Int>>,
    @SerializedName("test_petani_sub_kriteria")
    var testPetaniSubKriteria: List<List<Int>>
)