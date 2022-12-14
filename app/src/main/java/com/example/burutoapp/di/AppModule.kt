package com.example.burutoapp.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.burutoapp.data.local.HeroDatabase
import com.example.burutoapp.data.repository.LocalDataSourceImp
import com.example.burutoapp.domain.repository.LocalDataSource
import com.example.burutoapp.util.Constants.HERO_DATABASE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): HeroDatabase {
        return Room.databaseBuilder(
            context,
            HeroDatabase::class.java,
            HERO_DATABASE
        ).build()
    }

    @Provides
    @Singleton
    fun provideLocalDataSource(
        database: HeroDatabase
    ): LocalDataSource{
        return LocalDataSourceImp(
            heroDatabase = database
        )
    }
}
