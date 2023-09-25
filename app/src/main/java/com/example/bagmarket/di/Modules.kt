package com.example.bagmarket.di

import android.content.Context
import com.example.bagmarket.model.net.createApiService
import com.example.bagmarket.model.repository.user.UserRepository
import com.example.bagmarket.model.repository.user.UserRepositoryImpl
import com.example.bagmarket.ui.features.SignIn.SignInViewModel
import com.example.bagmarket.ui.features.signUp.SignUpViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val myModules = module {
    single { androidContext().getSharedPreferences("data", Context.MODE_PRIVATE) }
    single { createApiService() }

    single<UserRepository> { UserRepositoryImpl(get(), get()) }

    viewModel { SignUpViewModel(get()) }
    viewModel { SignInViewModel(get()) }

}