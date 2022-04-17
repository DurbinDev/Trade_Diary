package com.example.tradediary.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.tradediary.diaryentity.DiaryEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface DiaryDao {
    @Query("SELECT * FROM DiaryData")
    fun getAllData(): Flow<List<DiaryEntity>>

    @Query("SELECT * FROM DiaryData where id = id")
    fun getById(id: Int): DiaryEntity?

    @Insert
    fun add(item: List<DiaryEntity>)

    @Update
    fun update(item: DiaryEntity)

    @Delete
    fun delete(item: DiaryEntity)

    @Query("DELETE FROM DiaryData")
    fun deleteAll()
}