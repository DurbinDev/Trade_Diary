package com.example.tradediary.screen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tradediary.database.JobDataSource
import com.example.tradediary.model.Jobs
import com.example.tradediary.repository.DiaryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DiaryViewModel @Inject constructor(private val repository: DiaryRepository): ViewModel() {
     //var dairyList = mutableListOf<Jobs>()

    private val _jobList = MutableStateFlow<List<Jobs>>(emptyList())
    val jobList = _jobList.asStateFlow()

    init{
        //dairyList.addAll(JobDataSource().loadJobs())
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllJobs().distinctUntilChanged()
                .collect{ listOfJobs ->
                    if (listOfJobs.isNullOrEmpty()){
                        Log.d("Empty", "Empty List")
                    }else{
                        _jobList.value = listOfJobs
                    }
                    _jobList.value = listOfJobs
                }
        }
    }

    fun addJob(jobs: Jobs) = viewModelScope.launch{ repository.addJob(jobs)}
    fun updateJob(jobs: Jobs) = viewModelScope.launch{ repository.updateJob(jobs)}
    fun deleteJob(jobs: Jobs) = viewModelScope.launch{ repository.deleteJob(jobs)}
    fun getAllJobs(jobs: Jobs) = viewModelScope.launch{ repository.getAllJobs()}


//    fun deleteAllJobs(jobs: Jobs){
//        dairyList.removeAll(jobs)
//    }


}