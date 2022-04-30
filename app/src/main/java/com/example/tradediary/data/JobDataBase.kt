package com.example.tradediary.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.tradediary.model.Jobs
import com.example.tradediary.util.DateConvertor
import com.example.tradediary.util.UUIDConvertor


@Database(entities = [Jobs::class], version = 1, exportSchema = false )
@TypeConverters(DateConvertor::class, UUIDConvertor::class)
abstract class JobDataBase : RoomDatabase() {

    abstract fun jobDao(): DiaryDao
}