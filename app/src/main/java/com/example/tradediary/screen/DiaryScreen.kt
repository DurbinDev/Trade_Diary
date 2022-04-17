package com.example.tradediary.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.tradediary.widgets.DiaryIcons


@Composable
fun DiaryScreen(){
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

        AnimatedVisibility(visible = expanded) {
            DropDown()
        }
    }
}

@Composable
fun DropDown(){
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Text input Company")
        Text("Text input Job description")

            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .padding(4.dp))
            {
                Text("Save")
            }

        
    }
}