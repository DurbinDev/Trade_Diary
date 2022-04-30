package com.example.tradediary.repository

import com.example.tradediary.data.DiaryDao
import com.example.tradediary.model.Jobs
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject


class DiaryRepository @Inject constructor(private val diaryDao: DiaryDao){
    suspend fun addJob(jobs: Jobs) = diaryDao.insert(jobs)
    suspend fun updateJob(jobs: Jobs) = diaryDao.update(jobs)
    suspend fun deleteJob(jobs: Jobs) = diaryDao.deleteJob(jobs)
    suspend fun deleteAllJobs() = diaryDao.deleteAll()
    fun getAllJobs(): Flow<List<Jobs>> = diaryDao.getJobs().flowOn(Dispatchers.IO).conflate()
}