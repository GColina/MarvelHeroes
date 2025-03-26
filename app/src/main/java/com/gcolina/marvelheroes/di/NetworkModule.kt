package com.gcolina.marvelheroes.di

import com.gcolina.marvelheroes.data.HeroApi
import com.gcolina.marvelheroes.data.repository.HeroesDataSource
import com.gcolina.marvelheroes.data.repository.HeroesRepository
import com.gcolina.marvelheroes.data.repository.HeroesRepositoryImpl
import com.gcolina.marvelheroes.utils.Constants.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): HeroApi {
        return retrofit.create(HeroApi::class.java)
    }

    @Provides
    @Singleton
    fun providesHeroesRepository(heroesDataSource: HeroesDataSource): HeroesRepository {
        return HeroesRepositoryImpl(heroesDataSource)
    }
}