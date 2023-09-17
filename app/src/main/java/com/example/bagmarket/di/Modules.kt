package com.example.bagmarket.di

import com.example.bagmarket.ui.features.signUp.SignUpViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val myModules = module {
    viewModel{SignUpViewModel()}

}