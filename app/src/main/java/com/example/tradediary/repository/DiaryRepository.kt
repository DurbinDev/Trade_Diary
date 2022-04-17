package com.example.tradediary.repository

import com.example.tradediary.data.DiaryDao
import com.example.tradediary.diaryentity.DiaryEntity
import kotlinx.coroutines.flow.Flow

class DiaryRepository(private val diaryDao: DiaryDao) {
    val readAllData: Flow<List<DiaryEntity>> = diaryDao.getAllData()

    suspend fun addEntry(item: List<DiaryEntity>){
        diaryDao.add(item)
    }

    suspend fun updateEntry(item: DiaryEntity){
        diaryDao.update(item)
    }

    suspend fun deleteEntry(item: DiaryEntity){
        diaryDao.delete(item)
    }

    suspend fun deleteAllEntries(){
        diaryDao.deleteAll()
    }
}