package io.github.alexkamanin.mockcept.sample.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.alexkamanin.mockcept.sample.data.api.FollowersApi
import io.github.alexkamanin.mockcept.sample.data.repository.FollowerRepositoryImpl
import io.github.alexkamanin.mockcept.sample.domain.repository.FollowerRepository
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface FollowersModule {

    companion object {

        @Provides
        @Singleton
        fun provideFollowersApi(retrofit: Retrofit): FollowersApi =
            retrofit.create()
    }

    @Binds
    @Singleton
    fun bindFollowersRepository(impl: FollowerRepositoryImpl): FollowerRepository
}