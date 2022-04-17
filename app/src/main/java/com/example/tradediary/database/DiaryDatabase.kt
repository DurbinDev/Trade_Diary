package com.example.tradediary.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.tradediary.data.DiaryDao
import com.example.tradediary.diaryentity.DiaryEntity
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized

@Database(entities = [DiaryEntity::class], version = 1, exportSchema = false)
abstract class DiaryDatabase: RoomDatabase(){
    abstract fun diaryDoa(): DiaryDao

    companion object{
        private var INSTANCE: DiaryDatabase? = null

        @OptIn(InternalCoroutinesApi::class)
        fun getInstance(context: Context): DiaryDatabase {
            synchronized(this){
                return INSTANCE?: Room.databaseBuilder(
                    context.applicationContext,
                    DiaryDatabase::class.java,
                    "diary_database"
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }
}