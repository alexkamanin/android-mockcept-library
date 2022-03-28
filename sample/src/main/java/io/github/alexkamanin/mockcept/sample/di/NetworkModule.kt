package io.github.alexkamanin.mockcept.sample.di

import android.content.Context
import io.github.alexkamanin.mockcept.Mockcept
import io.github.alexkamanin.mockcept.sample.handler.AccountHandler
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val BACKEND_ENDPOINT = "https://mock-api.com/"

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    @Provides
    @Singleton
    fun provideMockcept(@ApplicationContext context: Context): Mockcept =
        Mockcept(
            context = context,
            handlers = mockceptHandlers
        )

    private val mockceptHandlers =
        sequenceOf(AccountHandler)

    @Provides
    @Singleton
    fun provideAuthorizedOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor,
        mockcept: Mockcept
    ): OkHttpClient =
        OkHttpClient
            .Builder()
            .addInterceptor(httpLoggingInterceptor)
            .addInterceptor(mockcept)
            .build()

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient): Retrofit =
        Retrofit
            .Builder()
            .baseUrl(BACKEND_ENDPOINT)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
}