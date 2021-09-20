package com.ftp.coffeenuity.di

import com.ftp.coffeenuity.data.source.AppRepositoryImpl
import com.ftp.coffeenuity.data.source.remote.RemoteDataSource
import com.ftp.coffeenuity.data.source.remote.network.ApiServiceFuzzyAHP
import com.ftp.coffeenuity.domain.repositories.AppRepository
import com.ftp.coffeenuity.domain.usecases.auth.AuthInteractor
import com.ftp.coffeenuity.domain.usecases.auth.AuthUseCase
import com.ftp.coffeenuity.domain.usecases.fuzzy.FuzzyAHPInteractor
import com.ftp.coffeenuity.domain.usecases.fuzzy.FuzzyAHPUseCase
import com.ftp.coffeenuity.domain.usecases.questioner.QuestionerInteractor
import com.ftp.coffeenuity.domain.usecases.questioner.QuestionerUseCase
import com.ftp.coffeenuity.presentation.auth.AuthViewModel
import com.ftp.coffeenuity.presentation.home.questioner.FuzzyViewModel
import com.ftp.coffeenuity.presentation.QuestionerViewModel
import com.ftp.coffeenuity.utils.BaseEndpoints.BASE_APP_URL
import com.ftp.coffeenuity.utils.Constants
import com.google.firebase.auth.FirebaseAuth
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val useCaseModule = module {
    single<FuzzyAHPUseCase> { FuzzyAHPInteractor(get()) }
    single<AuthUseCase> { AuthInteractor(get()) }
    single<QuestionerUseCase> { QuestionerInteractor(get()) }
}

val viewModelModule = module {
    viewModel { AuthViewModel(get()) }
    viewModel { FuzzyViewModel(get()) }
    viewModel { QuestionerViewModel(get()) }
}

val networkModule = module {
    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(Constants.NETWORK_TIME_OUT, TimeUnit.SECONDS)
            .readTimeout(Constants.NETWORK_TIME_OUT, TimeUnit.SECONDS)
            .build()
    }
    single {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_APP_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(ApiServiceFuzzyAHP::class.java)
    }
}

val repositoryModule = module {
    single { FirebaseAuth.getInstance() }
    single { RemoteDataSource(get(), get()) }
    single<AppRepository> {
        AppRepositoryImpl(get())
    }
}