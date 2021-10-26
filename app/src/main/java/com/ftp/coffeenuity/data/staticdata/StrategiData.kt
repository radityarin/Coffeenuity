package com.ftp.coffeenuity.data.staticdata

import com.ftp.coffeenuity.domain.model.Strategi
import com.ftp.coffeenuity.domain.model.StrategiItem
import com.ftp.coffeenuity.utils.Constants

object StrategiData {

    fun getStrategi(aktor: String, kategori: String, variabel: String): Strategi? {
        return strategiList.find { it.aktor == aktor && it.kategori == kategori && it.variabel == variabel }
    }

    var strategiList = listOf(
        Strategi(
            aktor = Constants.PETANI,
            kategori = Constants.BURUK,
            variabel = Constants.EKONOMI,
            strategi = listOf(
                StrategiItem(
                    no = "1",
                    strategi = "Meningkatkan kualitas buah kopi dengan menerapkan Good Agricultural Practices (GAP)"
                ),
                StrategiItem(
                    no = "2",
                    strategi = "Melakukan sortasi dan grading pada green bean"
                ),
                StrategiItem(
                    no = "3",
                    strategi = "Meningkatkan kemudahan akses permodalan"
                ),
                StrategiItem(
                    no = "4",
                    strategi = "Memperluas jaringan pemasaran"
                ),
                StrategiItem(
                    no = "5",
                    strategi = "Menerapkan praktik manajemen usaha tani"
                ),
                StrategiItem(
                    no = "6",
                    strategi = "Melakukan optimasi penggunaan lahan"
                ),
            )
        ),
        Strategi(
            aktor = Constants.PETANI,
            kategori = Constants.BURUK,
            variabel = Constants.SOSIAL,
            strategi = listOf(
                StrategiItem(
                    no = "1",
                    strategi = "Memperluas kerjasama dengan pelaku usaha/IKM kopi"
                ),
                StrategiItem(
                    no = "2",
                    strategi = "Meningkatkan keterampilan & pengetahuan tentang GAP dan GMP dengan aktif mengikuti pelatihan & pendampingan"
                ),
                StrategiItem(
                    no = "3",
                    strategi = "Meningkatkan kesadaran petani tentang pentingnya kualitas biji kopi dengan membuat reward & punishment proses pemetikan buah kopi"
                )
            )
        ),
        Strategi(
            aktor = Constants.PETANI,
            kategori = Constants.BURUK,
            variabel = Constants.LINGKUNGAN,
            strategi = listOf(
                StrategiItem(
                    no = "1",
                    strategi = "Memanfaatkan limbah kulit buah kopi menjadi pakan ternak dan pupuk organik"
                ),
                StrategiItem(
                    no = "2",
                    strategi = "Memanfaatkan limbah kulit green bean menjadi pupuk organik"
                ),
                StrategiItem(
                    no = "3",
                    strategi = "Mengurangi limbah cemaran green bean dengan melakukan sortasi"
                ),
                StrategiItem(
                    no = "4",
                    strategi = "Mengurangi penggunaan pupuk kimia dengan mensubstitusi pupuk organik"
                )
            )
        ),
        Strategi(
            aktor = Constants.PETANI,
            kategori = Constants.KURANG,
            variabel = Constants.EKONOMI,
            strategi = listOf(
                StrategiItem(
                    no = "1",
                    strategi = "Melakukan sortasi dan grading pada green bean"
                ),
                StrategiItem(
                    no = "2",
                    strategi = "Meningkatkan kemudahan akses permodalan"
                ),
                StrategiItem(
                    no = "3",
                    strategi = "Memperluas jaringan pemasaran"
                ),
                StrategiItem(
                    no = "4",
                    strategi = "Memperbaiki praktik manajemen usaha tani"
                ),
                StrategiItem(
                    no = "5",
                    strategi = "Optimasi penggunaan lahan tani"
                )
            )
        ),
        Strategi(
            aktor = Constants.PETANI,
            kategori = Constants.KURANG,
            variabel = Constants.SOSIAL,
            strategi = listOf(
                StrategiItem(
                    no = "1",
                    strategi = "Memperluas kerjasama dengan pelaku usaha/IKM kopi"
                ),
                StrategiItem(
                    no = "2",
                    strategi = "Meningkatkan keterampilan & pengetahuan tentang GAP dan GMP dengan aktif mengikuti pelatihan & pendampingan"
                ),
                StrategiItem(
                    no = "3",
                    strategi = "Meningkatkan kesadaran tentang pentingnya kualitas biji kopi dengan membuat reward & punishment proses pemetikan buah kopi"
                )
            )
        ),
        Strategi(
            aktor = Constants.PETANI,
            kategori = Constants.KURANG,
            variabel = Constants.LINGKUNGAN,
            strategi = listOf(
                StrategiItem(
                    no = "1",
                    strategi = "Memanfaatkan limbah kulit green bean menjadi pupuk organik"
                ),
                StrategiItem(
                    no = "2",
                    strategi = "Mengurangi limbah cemaran green bean dengan melakukan sortasi"
                )
            )
        ),
        Strategi(
            aktor = Constants.PETANI,
            kategori = Constants.CUKUP,
            variabel = Constants.EKONOMI,
            strategi = listOf(
                StrategiItem(
                    no = "1",
                    strategi = "Mempertahankan kualitas buah kopi dengan menerapkan Good Agricultural Practices (GAP)"
                ),
                StrategiItem(
                    no = "2",
                    strategi = "Mempertahankan proses sortasi dan grading pada green bean"
                ),
                StrategiItem(
                    no = "3",
                    strategi = "Mulai menerapkan pemasaran secara online"
                ),
                StrategiItem(
                    no = "4",
                    strategi = "Mempertahankan praktik manajemen usaha tani"
                ),
                StrategiItem(
                    no = "5",
                    strategi = "Melakukan perawatan lahan tani kopi"
                )
            )
        ),
        Strategi(
            aktor = Constants.PETANI,
            kategori = Constants.CUKUP,
            variabel = Constants.SOSIAL,
            strategi = listOf(
                StrategiItem(
                    no = "1",
                    strategi = "Menjaga hubungan baik dengan pelaku usaha/IKM kopi"
                ),
                StrategiItem(
                    no = "2",
                    strategi = "Tertib mematuhi peraturan reward & punishment petik buah kopi"
                )
            )
        ),
        Strategi(
            aktor = Constants.PETANI,
            kategori = Constants.CUKUP,
            variabel = Constants.LINGKUNGAN,
            strategi = listOf(
                StrategiItem(
                    no = "1",
                    strategi = "Memanfaatkan limbah kulit buah kopi menjadi pakan ternak dan pupuk organik"
                ),
                StrategiItem(
                    no = "2",
                    strategi = "Memanfaatkan limbah kulit green bean menjadi pupuk organik"
                )
            )
        ),
        Strategi(
            aktor = Constants.PETANI,
            kategori = Constants.BAIK,
            variabel = Constants.EKONOMI,
            strategi = listOf(
                StrategiItem(
                    no = "1",
                    strategi = "Mempertahankan kualitas buah kopi dengan menerapkan Good Agricultural Practices (GAP)"
                ),
                StrategiItem(
                    no = "2",
                    strategi = "Mempertahankan proses sortasi dan grading pada green bean"
                ),
                StrategiItem(
                    no = "3",
                    strategi = "Memasarkan produk secara online"
                ),
                StrategiItem(
                    no = "4",
                    strategi = "Mempertahankan praktik manajemen usaha tani"
                ),
                StrategiItem(
                    no = "5",
                    strategi = "Menjaga hubungan baik dengan pelaku usaha/IKM kopi"
                )
            )
        ),
        Strategi(
            aktor = Constants.PETANI,
            kategori = Constants.BAIK,
            variabel = Constants.SOSIAL,
            strategi = listOf(
                StrategiItem(
                    no = "1",
                    strategi = "Menjaga hubungan baik dengan pelaku usaha/IKM kopi"
                ),
                StrategiItem(
                    no = "2",
                    strategi = "Tertib mematuhi peraturan reward & punishment petik buah kopi"
                )
            )
        ),
        Strategi(
            aktor = Constants.PETANI,
            kategori = Constants.BAIK,
            variabel = Constants.LINGKUNGAN,
            strategi = listOf(
                StrategiItem(
                    no = "1",
                    strategi = "Memanfaatkan limbah kulit buah kopi menjadi pakan ternak dan pupuk organik"
                ),
                StrategiItem(
                    no = "2",
                    strategi = "Memanfaatkan limbah kulit green bean menjadi pupuk organik"
                )
            )
        ),
        Strategi(
            aktor = Constants.TENGKULAK,
            kategori = Constants.BURUK,
            variabel = Constants.EKONOMI,
            strategi = listOf(
                StrategiItem(
                    no = "1",
                    strategi = "Melakukan sortasi dan grading pada green bean"
                ),
                StrategiItem(
                    no = "2",
                    strategi = "Memperluas jaringan pemasaran"
                ),
                StrategiItem(
                    no = "3",
                    strategi = "Melakukan pencatatan keuangan"
                )
            )
        ),
        Strategi(
            aktor = Constants.TENGKULAK,
            kategori = Constants.BURUK,
            variabel = Constants.SOSIAL,
            strategi = listOf(
                StrategiItem(
                    no = "1",
                    strategi = "Memperluas kerjasama dengan pelaku usaha/IKM kopi"
                ),
                StrategiItem(
                    no = "2",
                    strategi = "Menjaga hubungan baik dengan petani"
                ),
                StrategiItem(
                    no = "3",
                    strategi = "Meningkatkan kesadaran tengkulak tentang pentingnya kualitas biji kopi dengan menerapkan SOP penanganan pasca panen"
                )
            )
        ),
        Strategi(
            aktor = Constants.TENGKULAK,
            kategori = Constants.BURUK,
            variabel = Constants.LINGKUNGAN,
            strategi = listOf(
                StrategiItem(
                    no = "1",
                    strategi = "Mendaur ulang produk subgrade"
                ),
                StrategiItem(
                    no = "2",
                    strategi = "Menggukan kemasan yang ramah lingkungan"
                ),
                StrategiItem(
                    no = "3",
                    strategi = "Mengoptimasi sistem distribusi untuk minimasi emisi akibat transportasi"
                )
            )
        ),
        Strategi(
            aktor = Constants.TENGKULAK,
            kategori = Constants.KURANG,
            variabel = Constants.EKONOMI,
            strategi = listOf(
                StrategiItem(
                    no = "1",
                    strategi = "Melakukan sortasi dan grading pada green bean"
                ),
                StrategiItem(
                    no = "2",
                    strategi = "Membedakan produk grean bean sesuai dengan gradenya"
                ),
                StrategiItem(
                    no = "3",
                    strategi = "Memperluas jaringan pemasaran"
                ),
                StrategiItem(
                    no = "4",
                    strategi = "Melakukan pencatatan keuangan"
                )
            )
        ),
        Strategi(
            aktor = Constants.TENGKULAK,
            kategori = Constants.KURANG,
            variabel = Constants.SOSIAL,
            strategi = listOf(
                StrategiItem(
                    no = "1",
                    strategi = "Memperluas kerjasama dengan pelaku usaha/IKM kopi"
                ),
                StrategiItem(
                    no = "2",
                    strategi = "Menjaga hubungan baik dengan petani"
                ),
                StrategiItem(
                    no = "3",
                    strategi = "Meningkatkan kesadaran tengkulak tentang pentingnya kualitas biji kopi dengan menerapkan SOP penanganan pasca panen"
                )
            )
        ),
        Strategi(
            aktor = Constants.TENGKULAK,
            kategori = Constants.KURANG,
            variabel = Constants.LINGKUNGAN,
            strategi = listOf(
                StrategiItem(
                    no = "1",
                    strategi = "Mendaur ulang produk subgrade"
                ),
                StrategiItem(
                    no = "2",
                    strategi = "Menggukan kemasan yang ramah lingkungan"
                ),
                StrategiItem(
                    no = "3",
                    strategi = "Mengoptimasi sistem distribusi untuk minimasi emisi akibat transportasi"
                )
            )
        ),
        Strategi(
            aktor = Constants.TENGKULAK,
            kategori = Constants.CUKUP,
            variabel = Constants.EKONOMI,
            strategi = listOf(
                StrategiItem(
                    no = "1",
                    strategi = "Mempertahankan proses sortasi dan grading pada green bean"
                ),
                StrategiItem(
                    no = "2",
                    strategi = "Mengembangkan produk grean bean sesuai dengan gradenya"
                ),
                StrategiItem(
                    no = "3",
                    strategi = "Mulai menerapkan pemasaran secara online"
                ),
                StrategiItem(
                    no = "4",
                    strategi = "Mempertahankan kegiatan pencatatan keuangan"
                )
            )
        ),
        Strategi(
            aktor = Constants.TENGKULAK,
            kategori = Constants.CUKUP,
            variabel = Constants.SOSIAL,
            strategi = listOf(
                StrategiItem(
                    no = "1",
                    strategi = "Menjaga hubungan baik dengan pelaku usaha/IKM kopi"
                ),
                StrategiItem(
                    no = "2",
                    strategi = "Menjaga hubungan baik dengan petani"
                )
            )
        ),
        Strategi(
            aktor = Constants.TENGKULAK,
            kategori = Constants.CUKUP,
            variabel = Constants.LINGKUNGAN,
            strategi = listOf(
                StrategiItem(
                    no = "1",
                    strategi = "Mendaur ulang produk subgrade"
                ),
                StrategiItem(
                    no = "2",
                    strategi = "Menggukan kemasan yang ramah lingkungan"
                ),
                StrategiItem(
                    no = "3",
                    strategi = "Mengoptimasi sistem distribusi untuk minimasi emisi akibat transportasi"
                )
            )
        ),
        Strategi(
            aktor = Constants.TENGKULAK,
            kategori = Constants.BAIK,
            variabel = Constants.EKONOMI,
            strategi = listOf(
                StrategiItem(
                    no = "1",
                    strategi = "Mempertahankan proses sortasi dan grading pada green bean"
                ),
                StrategiItem(
                    no = "2",
                    strategi = "Mengembangkan produk grean bean sesuai dengan gradenya"
                ),
                StrategiItem(
                    no = "3",
                    strategi = "Mulai menerapkan pemasaran secara online"
                ),
                StrategiItem(
                    no = "4",
                    strategi = "Mempertahankan kegiatan pencatatan keuangan"
                )
            )
        ),
        Strategi(
            aktor = Constants.TENGKULAK,
            kategori = Constants.BAIK,
            variabel = Constants.SOSIAL,
            strategi = listOf(
                StrategiItem(
                    no = "1",
                    strategi = "Menjaga hubungan baik dengan pelaku usaha/IKM kopi"
                ),
                StrategiItem(
                    no = "2",
                    strategi = "Menjaga hubungan baik dengan petani"
                )
            )
        ),
        Strategi(
            aktor = Constants.TENGKULAK,
            kategori = Constants.BAIK,
            variabel = Constants.LINGKUNGAN,
            strategi = listOf(
                StrategiItem(
                    no = "1",
                    strategi = "Mendaur ulang produk subgrade"
                ),
                StrategiItem(
                    no = "2",
                    strategi = "Menggukan kemasan yang ramah lingkungan"
                ),
                StrategiItem(
                    no = "3",
                    strategi = "Mengoptimasi sistem distribusi untuk minimasi emisi akibat transportasi"
                )
            )
        ),
        Strategi(
            aktor = Constants.ROASTERY,
            kategori = Constants.BURUK,
            variabel = Constants.EKONOMI,
            strategi = listOf(
                StrategiItem(
                    no = "1",
                    strategi = "Menyusun Standard Operational Procedure (SOP) Roasting"
                ),
                StrategiItem(
                    no = "2",
                    strategi = "Melakukan proses sortasi dan grading green bean"
                ),
                StrategiItem(
                    no = "3",
                    strategi = "Memperluas jaringan pemasaran"
                ),
                StrategiItem(
                    no = "4",
                    strategi = "Melakukan pencatatan keuangan"
                )
            )
        ),
        Strategi(
            aktor = Constants.ROASTERY,
            kategori = Constants.BURUK,
            variabel = Constants.SOSIAL,
            strategi = listOf(
                StrategiItem(
                    no = "1",
                    strategi = "Meningkatkan keterampilan & pengetahuan tentang teknik roasting dengan aktif mengikuti pelatihan & pendampingan"
                ),
                StrategiItem(
                    no = "2",
                    strategi = "Menjalin kerjasama dengan pemasok biji kopi"
                ),
                StrategiItem(
                    no = "3",
                    strategi = "Meningkatkan kesadaran tentang pentingnya kualitas kopi dengan menerapkan SOP produksi"
                ),
                StrategiItem(
                    no = "4",
                    strategi = "Menerapkan sistem reward & punishment kepatuhan SOP"
                )
            )
        ),
        Strategi(
            aktor = Constants.ROASTERY,
            kategori = Constants.BURUK,
            variabel = Constants.LINGKUNGAN,
            strategi = listOf(
                StrategiItem(
                    no = "1",
                    strategi = "Memodifikasi mesin roasting yang ramah lingkungan"
                ),
                StrategiItem(
                    no = "2",
                    strategi = "Mendaur ulang produk subgrade"
                )
            )
        ),
        Strategi(
            aktor = Constants.ROASTERY,
            kategori = Constants.KURANG,
            variabel = Constants.EKONOMI,
            strategi = listOf(
                StrategiItem(
                    no = "1",
                    strategi = "Melaksanakan Standard Operational Procedure (SOP) roasting"
                ),
                StrategiItem(
                    no = "2",
                    strategi = "Melakukan proses sortasi dan grading green bean"
                ),
                StrategiItem(
                    no = "3",
                    strategi = "Mulai menerapkan pemasaran secara online"
                ),
                StrategiItem(
                    no = "4",
                    strategi = "Melakukan pencatatan keuangan"
                )
            )
        ),
        Strategi(
            aktor = Constants.ROASTERY,
            kategori = Constants.KURANG,
            variabel = Constants.SOSIAL,
            strategi = listOf(
                StrategiItem(
                    no = "1",
                    strategi = "Meningkatkan kesadaran tentang pentingnya kualitas kopi dengan menerapkan SOP produksi"
                ),
                StrategiItem(
                    no = "2",
                    strategi = "Memperluas kerjasama dengan pemasok biji kopi"
                ),
                StrategiItem(
                    no = "3",
                    strategi = "Meningkatkan kesadaran tentang pentingnya kualitas kopi dengan menerapkan SOP produksi"
                ),
                StrategiItem(
                    no = "4",
                    strategi = "Menerapkan sistem reward & punishment kepatuhan SOP"
                )
            )
        ),
        Strategi(
            aktor = Constants.ROASTERY,
            kategori = Constants.KURANG,
            variabel = Constants.LINGKUNGAN,
            strategi = listOf(
                StrategiItem(
                    no = "1",
                    strategi = "Memodifikasi mesin roasting yang ramah lingkungan"
                ),
                StrategiItem(
                    no = "2",
                    strategi = "Mendaur ulang produk subgrade"
                )
            )
        ),
        Strategi(
            aktor = Constants.ROASTERY,
            kategori = Constants.CUKUP,
            variabel = Constants.EKONOMI,
            strategi = listOf(
                StrategiItem(
                    no = "1",
                    strategi = "Menerapkan quality control"
                ),
                StrategiItem(
                    no = "2",
                    strategi = "Meningkatkan jangkauan pemasaran online"
                ),
                StrategiItem(
                    no = "3",
                    strategi = "Menggunakan aplikasi pencatatan keuangan"
                )
            )
        ),
        Strategi(
            aktor = Constants.ROASTERY,
            kategori = Constants.CUKUP,
            variabel = Constants.SOSIAL,
            strategi = listOf(
                StrategiItem(
                    no = "1",
                    strategi = "Menjaga hubungan baik dengan pemasok biji kopi"
                ),
                StrategiItem(
                    no = "2",
                    strategi = "Tertib menerapkan SOP penanganan pasca panen"
                ),
                StrategiItem(
                    no = "3",
                    strategi = "Tertib mematuhi peraturan reward & punishment penerapan SOP"
                )
            )
        ),
        Strategi(
            aktor = Constants.ROASTERY,
            kategori = Constants.CUKUP,
            variabel = Constants.LINGKUNGAN,
            strategi = listOf(
                StrategiItem(
                    no = "1",
                    strategi = "Memodifikasi mesin roasting yang ramah lingkungan"
                ),
                StrategiItem(
                    no = "2",
                    strategi = "Memodifikasi produk subgrade menjadi kerajinan kreatif"
                )
            )
        ),
        Strategi(
            aktor = Constants.ROASTERY,
            kategori = Constants.BAIK,
            variabel = Constants.EKONOMI,
            strategi = listOf(
                StrategiItem(
                    no = "1",
                    strategi = "Menerapkan quality control"
                ),
                StrategiItem(
                    no = "2",
                    strategi = "Meningkatkan jangkauan pemasaran online"
                ),
                StrategiItem(
                    no = "3",
                    strategi = "Menggunakan aplikasi pencatatan keuangan"
                ),
                StrategiItem(
                    no = "4",
                    strategi = "Melakukan inovasi pengembangan teknik meroasting"
                ),
                StrategiItem(
                    no = "5",
                    strategi = "Melakukan inovasi pengemasan produk kopi roasted"
                )
            )
        ),
        Strategi(
            aktor = Constants.ROASTERY,
            kategori = Constants.BAIK,
            variabel = Constants.SOSIAL,
            strategi = listOf(
                StrategiItem(
                    no = "1",
                    strategi = "Meningkatkan jaringan kerjasama dengan petani"
                ),
                StrategiItem(
                    no = "2",
                    strategi = "Tertib menerapkan SOP penanganan pasca panen"
                ),
                StrategiItem(
                    no = "3",
                    strategi = "Tertib mematuhi peraturan reward & punishment penerapan SOP"
                )
            )
        ),
        Strategi(
            aktor = Constants.ROASTERY,
            kategori = Constants.BAIK,
            variabel = Constants.LINGKUNGAN,
            strategi = listOf(
                StrategiItem(
                    no = "1",
                    strategi = "Memodifikasi mesin roasting yang ramah lingkungan"
                ),
                StrategiItem(
                    no = "2",
                    strategi = "Memodifikasi produk subgrade menjadi kerajinan kreatif"
                )
            )
        )
    )

}