package com.example.tradediary.di

import android.content.Context
import androidx.room.Room
import com.example.tradediary.data.DiaryDao
import com.example.tradediary.data.JobDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Singleton
    @Provides
    fun provideJobsDao(jobDataBase: JobDataBase): DiaryDao
    = jobDataBase.jobDao()

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context):
            JobDataBase = Room.databaseBuilder(
        context,
        JobDataBase::class.java,
        "jobs_db").fallbackToDestructiveMigration().build()
}