package io.github.alexkamanin.mockcept.sample.di

import io.github.alexkamanin.mockcept.sample.data.api.AccountApi
import io.github.alexkamanin.mockcept.sample.data.repository.AccountRepositoryImpl
import io.github.alexkamanin.mockcept.sample.domain.repository.AccountRepository
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