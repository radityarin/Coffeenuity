package com.ftp.coffeenuity.domain.model

data class User(
    var idUser: String = "",
    var role: String ="",
    var email: String = "",
    var nama: String = "",
    var jenisKelamin: String = "",
    var usia: String = "",
    var address: String = "",
    var sifatUsaha: String = "",
    var kepemilikanLahan: String = "",
    var luasLahan: String = "",
    var pengalamanUsahaTani: String = "",
    var jumlahTenagaKerja: String = "",
    var produkYangDijual: String = "",
    var rangeHargaProduk: String = ""
)
