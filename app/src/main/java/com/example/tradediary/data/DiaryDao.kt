package com.example.tradediary.data

import androidx.compose.runtime.MutableState
import androidx.room.*
import com.example.tradediary.model.Jobs
import kotlinx.coroutines.flow.Flow

@Dao
interface DiaryDao{

    @Query("SELECT * from jobs_tbl")
    fun getJobs(): Flow<List<Jobs>>

    @Query("SELECT * from jobs_tbl where id = :id")
    suspend fun getJobById(id: String): Jobs

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(jobs: Jobs)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(jobs: Jobs)

    @Query("DELETE from jobs_tbl")
    suspend fun deleteAll()

    @Delete
    suspend fun deleteJob(jobs: Jobs)
}

