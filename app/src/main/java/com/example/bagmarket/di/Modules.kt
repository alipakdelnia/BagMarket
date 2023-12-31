package com.example.bagmarket.di

import android.content.Context
import androidx.room.Room
import com.example.bagmarket.model.dataBase.AppDatabase
import com.example.bagmarket.model.net.createApiService
import com.example.bagmarket.model.repository.cart.CartRepository
import com.example.bagmarket.model.repository.cart.CartRepositoryImpl
import com.example.bagmarket.model.repository.comment.CommentRepository
import com.example.bagmarket.model.repository.comment.CommentRepositoryImpl
import com.example.bagmarket.model.repository.product.ProductRepository
import com.example.bagmarket.model.repository.product.ProductRepositoryImpl
import com.example.bagmarket.model.repository.user.UserRepository
import com.example.bagmarket.model.repository.user.UserRepositoryImpl
import com.example.bagmarket.ui.features.SignIn.SignInViewModel
import com.example.bagmarket.ui.features.cart.CartViewModel
import com.example.bagmarket.ui.features.category.CategoryViewModel
import com.example.bagmarket.ui.features.mainScreen.MainScreenViewModel
import com.example.bagmarket.ui.features.product.ProductViewModel
import com.example.bagmarket.ui.features.profile.ProfileViewModel
import com.example.bagmarket.ui.features.signUp.SignUpViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val myModules = module {

    single { androidContext().getSharedPreferences("data", Context.MODE_PRIVATE) }
    single { createApiService() }

    single {
        Room.databaseBuilder(androidContext(), AppDatabase::class.java, "app_dataBase.db").build()
    }

    single<UserRepository> { UserRepositoryImpl(get(), get()) }
    single<ProductRepository> { ProductRepositoryImpl(get(), get<AppDatabase>().productDao()) }
    single<CommentRepository> { CommentRepositoryImpl(get()) }
    single<CartRepository> { CartRepositoryImpl(get(),get()) }

    viewModel { ProfileViewModel(get()) }
    viewModel { ProductViewModel(get(), get(), get()) }
    viewModel { SignUpViewModel(get()) }
    viewModel { SignInViewModel(get()) }
    viewModel { (isNetConnected: Boolean) -> MainScreenViewModel(get(), get(), isNetConnected) }
    viewModel { CategoryViewModel(get()) }
    viewModel { CartViewModel(get(), get()) }

}