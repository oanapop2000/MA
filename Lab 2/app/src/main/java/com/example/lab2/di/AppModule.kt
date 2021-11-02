package com.example.lab2.di

import com.example.lab2.players.repo.PlayersRepository
import com.example.lab2.players.repo.PlayersRepositoryImpl
import com.example.lab2.players.usecase.*
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import kotlin.text.Typography.dagger


@Module
@InstallIn(SingletonComponent::class)
class AppModule {


    @Module
    @InstallIn(SingletonComponent::class)
    interface AppModuleInt {

        @Binds
        @Singleton
        fun providePlayersRepository(repo: PlayersRepositoryImpl): PlayersRepository

        @Binds
        @Singleton
        fun provideGetPlayersUseCase(uc: GetPlayersUseCaseImpl): GetPlayersUseCase

        @Binds
        @Singleton
        fun provideGetPlayerUseCase(uc: GetPlayerUseCaseImpl): GetPlayerUseCase

        @Binds
        @Singleton
        fun provideAddPlayerUseCase(uc: AddPlayerUseCaseImpl): AddPlayerUseCase

        @Binds
        @Singleton
        fun provideModifyPlayerUseCase(uc: ModifyPlayerUseCaseImpl): ModifyPlayerUseCase

        @Binds
        @Singleton
        fun provideDeletePlayerUseCase(uc: DeletePlayerUseCaseImpl): DeletePlayerUseCase
    }

}