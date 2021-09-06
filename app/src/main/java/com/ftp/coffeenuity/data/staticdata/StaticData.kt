package com.ftp.coffeenuity.data.staticdata

import com.ftp.coffeenuity.R
import com.ftp.coffeenuity.domain.model.OnBoarding

object StaticData {

    fun getOnBoardingData(): List<OnBoarding> {
        val listOnBoardingModel = ArrayList<OnBoarding>()
        listOnBoardingModel.add(
            OnBoarding(
                R.drawable.ic_onboarding_1,
                "Menanam tanaman kopi dengan solusi keberlanjutan setalah panen akan memudahkan dalam melakukan peningkatan saat panen selanjutnya."
            )
        )
        listOnBoardingModel.add(
            OnBoarding(
                R.drawable.ic_onboarding_2,
                "Memudahkan petani dengan menggunakan smartphone dapat mengetahui tingkat keberlanjutan tanaman kopi."
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