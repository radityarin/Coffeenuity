package com.ftp.coffeenuity.data.staticdata

import com.ftp.coffeenuity.domain.model.QuestionerRange

object Questioner {

    val listSubKriteria = listOf<QuestionerRange>(
        QuestionerRange("Ekonomi","Sosial",0),
        QuestionerRange("Ekonomi","Lingkungan",0),
        QuestionerRange("Sosial","Lingkungan",0),
    )

    val listEkonomiPetani = listOf<QuestionerRange>(
        QuestionerRange("Keuntungan","Kualitas Produk",0),
        QuestionerRange("Keuntungan","Ketersediaan Produk",0),
        QuestionerRange("Keuntungan","Fleksibilitas / Waktu Siklus Budidaya",0),
        QuestionerRange("Keuntungan","Pelayanan Pelanggan",0),
        QuestionerRange("Keuntungan","Efisiensi Biaya",0),

        QuestionerRange("Kualitas Produk","Ketersediaan Produk",0),
        QuestionerRange("Kualitas Produk","Fleksibilitas / Waktu Siklus Budidaya",0),
        QuestionerRange("Kualitas Produk","Pelayanan Pelanggan",0),
        QuestionerRange("Kualitas Produk","Efisiensi Biaya",0),

        QuestionerRange("Ketersediaan Produk","Fleksibilitas / Waktu Siklus Budidaya",0),
        QuestionerRange("Ketersediaan Produk","Pelayanan Pelanggan",0),
        QuestionerRange("Ketersediaan Produk","Efisiensi Biaya",0),

        QuestionerRange("Fleksibilitas / Waktu Siklus Budidaya","Pelayanan Pelanggan",0),
        QuestionerRange("Fleksibilitas / Waktu Siklus Budidaya","Efisiensi Biaya",0),

        QuestionerRange("Pelayanan Pelanggan","Efisiensi Biaya",0),
    )

    val listSosialPetani = listOf<QuestionerRange>(
        QuestionerRange("Kepuasan Pelanggan","Kenyamanan kerja",0),
        QuestionerRange("Kepuasan Pelanggan","Keikutsertaan Petani dalam Kemitraan",0),
        QuestionerRange("Kepuasan Pelanggan","Keberlangsungan Taraf Hidup Petani",0),
        QuestionerRange("Kepuasan Pelanggan","Serapan Tenaga Kerja",0),
        QuestionerRange("Kepuasan Pelanggan","Terpeliharanya Budidaya Produktif Masyarakat",0),
        QuestionerRange("Kepuasan Pelanggan","Pengurangan Konflik antar Petani",0),
        QuestionerRange("Kepuasan Pelanggan","Keamanan Pangan",0),

        QuestionerRange("Kenyamanan kerja","Keikutsertaan Petani dalam Kemitraan",0),
        QuestionerRange("Kenyamanan kerja","Keberlangsungan Taraf Hidup Petani",0),
        QuestionerRange("Kenyamanan kerja","Serapan Tenaga Kerja",0),
        QuestionerRange("Kenyamanan kerja","Terpeliharanya Budidaya Produktif Masyarakat",0),
        QuestionerRange("Kenyamanan kerja","Pengurangan Konflik antar Petani",0),
        QuestionerRange("Kenyamanan kerja","Keamanan Pangan",0),

        QuestionerRange("Keikutsertaan Petani dalam Kemitraan","Keberlangsungan Taraf Hidup Petani",0),
        QuestionerRange("Keikutsertaan Petani dalam Kemitraan","Serapan Tenaga Kerja",0),
        QuestionerRange("Keikutsertaan Petani dalam Kemitraan","Terpeliharanya Budidaya Produktif Masyarakat",0),
        QuestionerRange("Keikutsertaan Petani dalam Kemitraan","Pengurangan Konflik antar Petani",0),
        QuestionerRange("Keikutsertaan Petani dalam Kemitraan","Keamanan Pangan",0),

        QuestionerRange("Keberlangsungan Taraf Hidup Petani","Serapan Tenaga Kerja",0),
        QuestionerRange("Keberlangsungan Taraf Hidup Petani","Terpeliharanya Budidaya Produktif Masyarakat",0),
        QuestionerRange("Keberlangsungan Taraf Hidup Petani","Pengurangan Konflik antar Petani",0),
        QuestionerRange("Keberlangsungan Taraf Hidup Petani","Keamanan Pangan",0),

        QuestionerRange("Serapan Tenaga Kerja","Terpeliharanya Budidaya Produktif Masyarakat",0),
        QuestionerRange("Serapan Tenaga Kerja","Pengurangan Konflik antar Petani",0),
        QuestionerRange("Serapan Tenaga Kerja","Keamanan Pangan",0),

        QuestionerRange("Terpeliharanya Budidaya Produktif Masyarakat","Pengurangan Konflik antar Petani",0),
        QuestionerRange("Terpeliharanya Budidaya Produktif Masyarakat","Keamanan Pangan",0),

        QuestionerRange("Pengurangan Konflik antar Petani","Keamanan Pangan",0),
    )

     val listLingkunganPetani = listOf<QuestionerRange>(
        QuestionerRange("Efisiensi Penggunaan Pupuk","Pengolahan Limbah",0),
        QuestionerRange("Efisiensi Penggunaan Pupuk","Pemanfaatan Limbah",0),
        QuestionerRange("Efisiensi Penggunaan Pupuk","Upaya Konservasi",0),

        QuestionerRange("Pengolahan Limbah","Pemanfaatan Limbah",0),
        QuestionerRange("Pengolahan Limbah","Upaya Konservasi",0),

        QuestionerRange("Pemanfaatan Limbah","Upaya Konservasi",0),
    )

    val listEkonomi = listOf<QuestionerRange>(
        QuestionerRange("Keuntungan","Kualitas Produk",0),
        QuestionerRange("Keuntungan","Ketersediaan Produk",0),
        QuestionerRange("Keuntungan","Fleksibilitas / Waktu Siklus Budidaya",0),
        QuestionerRange("Keuntungan","Pelayanan Pelanggan",0),
        QuestionerRange("Keuntungan","Efisiensi Biaya",0),

        QuestionerRange("Kualitas Produk","Ketersediaan Produk",0),
        QuestionerRange("Kualitas Produk","Fleksibilitas / Waktu Siklus Budidaya",0),
        QuestionerRange("Kualitas Produk","Pelayanan Pelanggan",0),
        QuestionerRange("Kualitas Produk","Efisiensi Biaya",0),

        QuestionerRange("Ketersediaan Produk","Fleksibilitas / Waktu Siklus Budidaya",0),
        QuestionerRange("Ketersediaan Produk","Pelayanan Pelanggan",0),
        QuestionerRange("Ketersediaan Produk","Efisiensi Biaya",0),

        QuestionerRange("Fleksibilitas / Waktu Siklus Budidaya","Pelayanan Pelanggan",0),
        QuestionerRange("Fleksibilitas / Waktu Siklus Budidaya","Efisiensi Biaya",0),

        QuestionerRange("Pelayanan Pelanggan","Efisiensi Biaya",0),
    )

    val listSosial = listOf<QuestionerRange>(
        QuestionerRange("Kepuasan Pelanggan","Kenyamanan kerja",0),
        QuestionerRange("Kepuasan Pelanggan","Keikutsertaan Petani dalam Kemitraan",0),
        QuestionerRange("Kepuasan Pelanggan","Keberlangsungan Taraf Hidup Petani",0),
        QuestionerRange("Kepuasan Pelanggan","Serapan Tenaga Kerja",0),
        QuestionerRange("Kepuasan Pelanggan","Terpeliharanya Budidaya Produktif Masyarakat",0),
        QuestionerRange("Kepuasan Pelanggan","Pengurangan Konflik antar Petani",0),
        QuestionerRange("Kepuasan Pelanggan","Keamanan Pangan",0),

        QuestionerRange("Kenyamanan kerja","Keikutsertaan Petani dalam Kemitraan",0),
        QuestionerRange("Kenyamanan kerja","Keberlangsungan Taraf Hidup Petani",0),
        QuestionerRange("Kenyamanan kerja","Serapan Tenaga Kerja",0),
        QuestionerRange("Kenyamanan kerja","Terpeliharanya Budidaya Produktif Masyarakat",0),
        QuestionerRange("Kenyamanan kerja","Pengurangan Konflik antar Petani",0),
        QuestionerRange("Kenyamanan kerja","Keamanan Pangan",0),

        QuestionerRange("Keikutsertaan Petani dalam Kemitraan","Keberlangsungan Taraf Hidup Petani",0),
        QuestionerRange("Keikutsertaan Petani dalam Kemitraan","Serapan Tenaga Kerja",0),
        QuestionerRange("Keikutsertaan Petani dalam Kemitraan","Terpeliharanya Budidaya Produktif Masyarakat",0),
        QuestionerRange("Keikutsertaan Petani dalam Kemitraan","Pengurangan Konflik antar Petani",0),
        QuestionerRange("Keikutsertaan Petani dalam Kemitraan","Keamanan Pangan",0),

        QuestionerRange("Keberlangsungan Taraf Hidup Petani","Serapan Tenaga Kerja",0),
        QuestionerRange("Keberlangsungan Taraf Hidup Petani","Terpeliharanya Budidaya Produktif Masyarakat",0),
        QuestionerRange("Keberlangsungan Taraf Hidup Petani","Pengurangan Konflik antar Petani",0),
        QuestionerRange("Keberlangsungan Taraf Hidup Petani","Keamanan Pangan",0),

        QuestionerRange("Serapan Tenaga Kerja","Terpeliharanya Budidaya Produktif Masyarakat",0),
        QuestionerRange("Serapan Tenaga Kerja","Pengurangan Konflik antar Petani",0),
        QuestionerRange("Serapan Tenaga Kerja","Keamanan Pangan",0),

        QuestionerRange("Terpeliharanya Budidaya Produktif Masyarakat","Pengurangan Konflik antar Petani",0),
        QuestionerRange("Terpeliharanya Budidaya Produktif Masyarakat","Keamanan Pangan",0),

        QuestionerRange("Pengurangan Konflik antar Petani","Keamanan Pangan",0),
    )

    val listLingkungan = listOf<QuestionerRange>(
        QuestionerRange("Efisiensi Penggunaan Energi","Pengolahan Limbah",0),
        QuestionerRange("Efisiensi Penggunaan Energi","Pemanfaatan Limbah",0),
        QuestionerRange("Efisiensi Penggunaan Energi","Upaya Konservasi",0),

        QuestionerRange("Pengolahan Limbah","Pemanfaatan Limbah",0),
        QuestionerRange("Pengolahan Limbah","Upaya Konservasi",0),

        QuestionerRange("Pemanfaatan Limbah","Upaya Konservasi",0),
    )

    val listEkonomiKeberlanjutanPetani = listOf<QuestionerRange>(
        QuestionerRange("Bagaimana tingkat keuntungan ditinjau dari sisi nilai keberlanjutan?","",0),
        QuestionerRange("Bagaimana kualitas produk ditinjau dari sisi nilai keberlanjutan?","",0),
        QuestionerRange("Bagaimana ketersediaan produk ditinjau dari sisi nilai keberlanjutan?","",0),
        QuestionerRange("Bagaimana fleksibilitas/waktu siklus budidaya ditinjau dari sisi nilai keberlanjutan?","",0),
        QuestionerRange("Bagaimana pelayanan pelanggan ditinjau dari sisi nilai keberlanjutan?","",0),
        QuestionerRange("Bagaimana efisiensi biaya ditinjau dari sisi nilai keberlanjutan?","",0),
    )

    val listSosialKeberlanjutanPetani = listOf<QuestionerRange>(
        QuestionerRange("Bagaimana kepuasan pelanggan ditinjau dari sisi nilai keberlanjutan?","",0),
        QuestionerRange("Bagaimana kenyamanan bekerja ditinjau dari sisi nilai keberlanjutan?","",0),
        QuestionerRange("Bagaimana keikutsertaan dalam kemitraan ditinjau dari sisi nilai keberlanjutan?","",0),
        QuestionerRange("Bagaimana keberlangsungan taraf hidup ditinjau dari sisi nilai keberlanjutan?","",0),
        QuestionerRange("Bagaimana serapan tenaga ditinjau dari sisi nilai keberlanjutan?","",0),
        QuestionerRange("Bagaimana terpeliharanya budidaya produktif masyarakat ditinjau dari sisi nilai keberlanjutan?","",0),
        QuestionerRange("Bagaimana pengurangan konflik antar petani ditinjau dari sisi nilai keberlanjutan?","",0),
        QuestionerRange("Bagaimana keamanan pangan ditinjau dari sisi nilai keberlanjutan?","",0),
    )

    val listLingkunganKeberlanjutanPetani = listOf<QuestionerRange>(
        QuestionerRange("Bagaimana efisiensi penggunaan pupuk ditinjau dari sisi nilai keberlanjutan?","",0),
        QuestionerRange("Bagaimana pengolahan limbah ditinjau dari sisi nilai keberlanjutan?","",0),
        QuestionerRange("Bagaimana pemanfaatan limbah ditinjau dari sisi nilai keberlanjutan?","",0),
        QuestionerRange("Bagaimana upaya konservasi ditinjau dari sisi nilai keberlanjutan?","",0),
    )

    val listEkonomiKeberlanjutan = listOf<QuestionerRange>(
        QuestionerRange("Bagaimana tingkat keuntungan ditinjau dari sisi nilai keberlanjutan?","",0),
        QuestionerRange("Bagaimana kualitas produk ditinjau dari sisi nilai keberlanjutan?","",0),
        QuestionerRange("Bagaimana ketersediaan produk ditinjau dari sisi nilai keberlanjutan?","",0),
        QuestionerRange("Bagaimana fleksibilitas/waktu siklus produksi ditinjau dari sisi nilai keberlanjutan?","",0),
        QuestionerRange("Bagaimana pelayanan pelanggan ditinjau dari sisi nilai keberlanjutan?","",0),
        QuestionerRange("Bagaimana efisiensi biaya ditinjau dari sisi nilai keberlanjutan?","",0),
    )

    val listSosialKeberlanjutan = listOf<QuestionerRange>(
        QuestionerRange("Bagaimana kepuasan pelanggan ditinjau dari sisi nilai keberlanjutan?","",0),
        QuestionerRange("Bagaimana kenyamanan bekerja ditinjau dari sisi nilai keberlanjutan?","",0),
        QuestionerRange("Bagaimana keikutsertaan dalam kemitraan ditinjau dari sisi nilai keberlanjutan?","",0),
        QuestionerRange("Bagaimana keberlangsungan taraf hidup ditinjau dari sisi nilai keberlanjutan?","",0),
        QuestionerRange("Bagaimana serapan tenaga ditinjau dari sisi nilai keberlanjutan?","",0),
        QuestionerRange("Bagaimana terpeliharanya budidaya produktif masyarakat ditinjau dari sisi nilai keberlanjutan?","",0),
        QuestionerRange("Bagaimana pengurangan konflik antar petani ditinjau dari sisi nilai keberlanjutan?","",0),
        QuestionerRange("Bagaimana keamanan pangan ditinjau dari sisi nilai keberlanjutan?","",0),
    )

    val listLingkunganKeberlanjutan = listOf<QuestionerRange>(
        QuestionerRange("Bagaimana efisiensi penggunaan energi ditinjau dari sisi nilai keberlanjutan?","",0),
        QuestionerRange("Bagaimana pengolahan limbah ditinjau dari sisi nilai keberlanjutan?","",0),
        QuestionerRange("Bagaimana pemanfaatan limbah ditinjau dari sisi nilai keberlanjutan?","",0),
        QuestionerRange("Bagaimana upaya konservasi ditinjau dari sisi nilai keberlanjutan?","",0),
    )

    val listEkonomiKeberlanjutanRoastery = listOf<QuestionerRange>(
        QuestionerRange("Bagaimana tingkat keuntungan ditinjau dari sisi nilai keberlanjutan?","",0),
        QuestionerRange("Bagaimana kualitas produk ditinjau dari sisi nilai keberlanjutan?","",0),
        QuestionerRange("Bagaimana ketersediaan produk ditinjau dari sisi nilai keberlanjutan?","",0),
        QuestionerRange("Bagaimana fleksibilitas/waktu siklus produksi ditinjau dari sisi nilai keberlanjutan?","",0),
        QuestionerRange("Bagaimana pelayanan pelanggan ditinjau dari sisi nilai keberlanjutan?","",0),
        QuestionerRange("Bagaimana efisiensi biaya ditinjau dari sisi nilai keberlanjutan?","",0),
    )

    val listSosialKeberlanjutanRoastery = listOf<QuestionerRange>(
        QuestionerRange("Bagaimana kepuasan pelanggan ditinjau dari sisi nilai keberlanjutan?","",0),
        QuestionerRange("Bagaimana kenyamanan bekerja ditinjau dari sisi nilai keberlanjutan?","",0),
        QuestionerRange("Bagaimana keikutsertaan dalam kemitraan ditinjau dari sisi nilai keberlanjutan?","",0),
        QuestionerRange("Bagaimana keberlangsungan taraf hidup ditinjau dari sisi nilai keberlanjutan?","",0),
        QuestionerRange("Bagaimana serapan tenaga ditinjau dari sisi nilai keberlanjutan?","",0),
        QuestionerRange("Bagaimana terpeliharanya budidaya produktif masyarakat ditinjau dari sisi nilai keberlanjutan?","",0),
        QuestionerRange("Bagaimana pengurangan konflik antar petani ditinjau dari sisi nilai keberlanjutan?","",0),
        QuestionerRange("Bagaimana keamanan pangan ditinjau dari sisi nilai keberlanjutan?","",0),
    )

    val listLingkunganKeberlanjutanRoastery = listOf<QuestionerRange>(
        QuestionerRange("Bagaimana efisiensi penggunaan pupuk ditinjau dari sisi nilai keberlanjutan?","",0),
        QuestionerRange("Bagaimana pengolahan limbah ditinjau dari sisi nilai keberlanjutan?","",0),
        QuestionerRange("Bagaimana pemanfaatan limbah ditinjau dari sisi nilai keberlanjutan?","",0),
        QuestionerRange("Bagaimana upaya konservasi ditinjau dari sisi nilai keberlanjutan?","",0),
    )
}