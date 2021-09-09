package com.ftp.coffeenuity.di

import com.ftp.coffeenuity.data.source.AppRepositoryImpl
import com.ftp.coffeenuity.data.source.remote.RemoteDataSource
import com.ftp.coffeenuity.data.source.remote.network.ApiServiceFuzzyAHP
import com.ftp.coffeenuity.domain.repositories.AppRepository
import com.ftp.coffeenuity.domain.usecases.auth.AuthInteractor
import com.ftp.coffeenuity.domain.usecases.auth.AuthUseCase
import com.ftp.coffeenuity.domain.usecases.fuzzy.FuzzyAHPInteractor
import com.ftp.coffeenuity.domain.usecases.fuzzy.FuzzyAHPUseCase
import com.ftp.coffeenuity.presentation.auth.AuthViewModel
import com.ftp.coffeenuity.presentation.auth.FuzzyViewModel
import com.ftp.coffeenuity.utils.BaseEndpoints.BASE_APP_URL
import com.ftp.coffeenuity.utils.Constants
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.storage.FirebaseStorage
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val useCaseModule = module {
    single<FuzzyAHPUseCase> { FuzzyAHPInteractor(get()) }
    single<AuthUseCase> { AuthInteractor(get()) }
}

val viewModelModule = module {
    viewModel { AuthViewModel(get()) }
    viewModel { FuzzyViewModel(get()) }
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