package com.github.alexkamanin.mockcept.di

import com.github.alexkamanin.mockcept.data.api.AccountApi
import com.github.alexkamanin.mockcept.data.repository.AccountRepositoryImpl
import com.github.alexkamanin.mockcept.domain.repository.AccountRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface AccountModule {

    companion object {

        @Provides
        @Singleton
        fun provideAccountApi(retrofit: Retrofit): AccountApi =
            retrofit.create()
    }

    @Binds
    @Singleton
    fun bindAccountRepository(impl: AccountRepositoryImpl): AccountRepository
}