package com.example.tradediary.diaryentity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "DiaryData")
data class DiaryEntity (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int,

    @ColumnInfo(name = "company")
    var company: String,

    @ColumnInfo(name = "description")
    var description: String,

    @ColumnInfo(name = "startTime")
    var startTime: String,

    @ColumnInfo(name = "startDate")
    var startDate: String
    )
