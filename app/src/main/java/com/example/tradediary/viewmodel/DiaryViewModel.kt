package com.example.tradediary.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tradediary.database.DiaryDatabase
import com.example.tradediary.diaryentity.DiaryEntity
import com.example.tradediary.repository.DiaryRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class DiaryViewModel (application: Application): AndroidViewModel(application){
    private val readAllData: Flow<List<DiaryEntity>>
    private val repository: DiaryRepository

    init {
        val diaryDao = DiaryDatabase.getInstance(application).diaryDoa()
        repository = DiaryRepository(diaryDao)
        readAllData = repository.readAllData
    }

    fun addEntry(item: List<DiaryEntity>){
        viewModelScope.launch(Dispatchers.IO){
            repository.addEntry(item)
        }
    }

    fun updateEntry(item: DiaryEntity){
        viewModelScope.launch(Dispatchers.IO){
            repository.updateEntry(item)
        }
    }

    fun deleteEntry(item: DiaryEntity){
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteEntry(item)
        }
    }

    fun deleteAllEntries(){
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteAllEntries()
        }
    }
}