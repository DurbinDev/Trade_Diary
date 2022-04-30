package com.example.tradediary.screen

import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.rounded.AdsClick
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.tradediary.components.DiaryButton
import com.example.tradediary.components.DiaryInputText
import com.example.tradediary.model.Jobs
import com.example.tradediary.util.formatDate
import com.example.tradediary.widgets.DiaryIcons
import java.time.format.DateTimeFormatter
import java.util.*


@Composable
fun DiaryScreen(
    jobs: List<Jobs>,
    onAddJob: (Jobs) -> Unit,
    onDeleteJob: (Jobs) -> Unit
){
    var expanded by remember {
        mutableStateOf(false)
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()) {

        TopAppBar(
            title = {
                Text(text = "Trade Diary")
            },
            actions = {
                DiaryIcons(
                    imageVector = Icons.Default.Add,
                    onClick = { 
                        expanded = !expanded
                    })
            },
            backgroundColor = Color(0xFFF83C00))

        AnimatedVisibility(expanded) {

            var company by remember {
                mutableStateOf("")
            }
            var description by remember {
                mutableStateOf("")
            }
            val context = LocalContext.current
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally) {
                DiaryInputText(
                    modifier = Modifier.padding(top = 10.dp, bottom = 20.dp),
                    text = company,
                    label = "Add Company",
                    onTextChange = {
                        if (it.all { char ->
                                char.isLetter() || char.isWhitespace()
                            })
                            company = it
                    }){

                }
                DiaryInputText(
                    modifier = Modifier.padding(top = 10.dp, bottom = 20.dp),
                    text = description,
                    label = "Job description",
                    onTextChange = {
                        if (it.all { char ->
                                char.isLetter() || char.isWhitespace()
                            })
                            description = it
                    }){

                }
                DiaryButton(
                    modifier = Modifier.padding(bottom = 10.dp),
                    text = "Save",
                    onClick = {
                        if (company.isNotBlank() && description.isNotBlank()){
                            onAddJob(Jobs(
                                company = company,
                                description = description))
                            company = ""
                            description = ""
                            Toast.makeText(context, "Job Added", Toast.LENGTH_SHORT).show()
                        }
                    }
                )
            }
        }
        LazyColumn(){
            items(jobs){ jobs ->
                DiaryEntryRow(
                    jobs = jobs,
                    onAddJob = {
                        onAddJob(jobs)
                    },
                    onDeleteJob = {
                        onDeleteJob(jobs)

                    })

            }
        }
    }
}

//@Composable
//fun DropDown(
//    onAddJob: (Jobs) -> Unit
//){
//
//    var company by remember {
//        mutableStateOf("")
//    }
//    var description by remember {
//        mutableStateOf("")
//    }
//    val context = LocalContext.current
//    Column(
//        modifier = Modifier.fillMaxWidth(),
//        horizontalAlignment = Alignment.CenterHorizontally) {
//        DiaryInputText(
//            modifier = Modifier.padding(top = 10.dp, bottom = 20.dp),
//            text = company,
//            label = "Add Company",
//            onTextChange = {
//                if (it.all { char ->
//                        char.isLetter() || char.isWhitespace()
//                    })
//                      company = it
//            }){
//
//        }
//        DiaryInputText(
//            modifier = Modifier.padding(top = 10.dp, bottom = 20.dp),
//            text = description,
//            label = "Job description",
//            onTextChange = {
//                if (it.all { char ->
//                        char.isLetter() || char.isWhitespace()
//                    })
//                    description = it
//            }){
//
//        }
//        DiaryButton(
//            modifier = Modifier.padding(bottom = 10.dp),
//            text = "Save",
//            onClick = {
//                      if (company.isNotBlank() && description.isNotBlank()){
//                          onAddJob(Jobs(company = company, description = description))
//                          company = ""
//                          description = ""
//                          Toast.makeText(context, "Job Added", Toast.LENGTH_SHORT).show()
//
//
//                      }
//            }
//        )
//    }
//}

@Composable
fun DiaryEntryRow(
    jobs: Jobs,
    modifier: Modifier = Modifier,
    onDeleteJob: (Jobs) -> Unit,
    onAddJob: (Jobs) -> Unit,

    ){
    Surface(
        modifier = Modifier
            .padding(4.dp)
            .clip(RoundedCornerShape(bottomStart = 33.dp, topEnd = 33.dp))
            .fillMaxWidth(),
        color = Color(0xFFF83C00),
        elevation = 6.dp
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween) {
            Column(
                Modifier
                    .padding(horizontal = 14.dp, vertical = 6.dp)
                    .clickable {  }
                    .width(300.dp),
                horizontalAlignment = Alignment.Start) {
                Text(
                    color = Color(0xFFB9B9B9),
                    text = jobs.company,
                    style = MaterialTheme.typography.h6)
                Text(
                    text = jobs.description,
                    style = MaterialTheme.typography.subtitle1)
                Text(
                    modifier = Modifier.padding(top = 10.dp),
                    fontWeight = FontWeight.Bold,
                    text = formatDate(jobs.dateTime.time),
                    style = MaterialTheme.typography.subtitle2)
            }
            Column() {
                Icon(
                    imageVector = Icons.Rounded.AdsClick,
                    contentDescription = "Tick Icon",
                    modifier = Modifier
                        .padding(top = 15.dp, bottom = 15.dp)
                        .clickable {  })
                Icon(
                    imageVector = Icons.Rounded.Delete,
                    contentDescription = "Delete icon",
                    modifier = Modifier
                        .padding(top = 1.dp, end = 15.dp)
                        .clickable {
                            onDeleteJob(jobs)
                        })
            }

        }

    }
}




