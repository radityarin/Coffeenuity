package com.ftp.coffeenuity.data.staticdata

import com.ftp.coffeenuity.R
import com.ftp.coffeenuity.domain.model.OnBoarding

object StaticData {

    fun getOnBoardingData(): List<OnBoarding> {
        val listOnBoardingModel = ArrayList<OnBoarding>()
        listOnBoardingModel.add(
            OnBoarding(
                R.drawable.ic_onboarding_1,
                "Selamat Datang\n" +
                        "Di Sistem Penunjang Keputusan Peningkatan Keberlanjutan Rantai Pasok Agroindustri"
            )
        )
        listOnBoardingModel.add(
            OnBoarding(
                R.drawable.ic_onboarding_2,
                "Sistem ini dirancang untuk memudahkan peneliti untuk menilai tingkat keberlanjutan rantai pasok dan merumuskan strategi peningkatannya"
            )
        )
        listOnBoardingModel.add(
            OnBoarding(
                R.drawable.ic_onboarding_3,
                "Dengan bergabung dengan kami anda akan mudah dalam menganalisis tingkat berkelanjutan tanaman kopi anda"
            )
        )
        return listOnBoardingModel
    }
}