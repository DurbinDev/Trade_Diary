package com.example.tradediary

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tradediary.model.Jobs
import com.example.tradediary.screen.DiaryScreen
import com.example.tradediary.screen.DiaryViewModel
import com.example.tradediary.ui.theme.TradeDiaryTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TradeDiaryTheme {
                // A surface container using the 'background' color from the theme
                Surface {
                    val diaryViewModel: DiaryViewModel by viewModels()

                        DiaryJobApp(diaryViewModel)

                }
            }
        }
    }
}
@Composable
fun DiaryJobApp(diaryViewModel: DiaryViewModel){
    val diaryList = diaryViewModel.jobList.collectAsState().value

    DiaryScreen(
        jobs = diaryList,
        onAddJob = {
            diaryViewModel.addJob(it)
        },
        onDeleteJob = {
            diaryViewModel.deleteJob(it)
        })

}

@Composable
fun DiaryApp(content: @Composable () -> Unit){
    TradeDiaryTheme() {
        content()
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TradeDiaryTheme {
        val jobsList = remember {
            mutableStateListOf<Jobs>()
        }
        DiaryApp{
            DiaryScreen(
                jobs = jobsList,
                onAddJob = {
                    jobsList.add(it)
                },
                onDeleteJob = {
                    jobsList.remove(it)
                })
    }

    }
}