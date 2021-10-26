package com.ftp.coffeenuity.domain.model

data class Strategi(
    var aktor: String = "",
    var kategori: String = "",
    var variabel: String = "",
    var strategi: List<StrategiItem> = emptyList(),
)