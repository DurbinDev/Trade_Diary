package com.example.tradediary.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Instant
import java.time.LocalDateTime
import java.util.*


@Entity(tableName = "jobs_tbl")
data class Jobs(
    @PrimaryKey
    val id: UUID = UUID.randomUUID(),

    @ColumnInfo(name = "job_company")
    val company: String,

    @ColumnInfo(name = "job_description")
    val description: String,

    @ColumnInfo(name = "job_entryDateTime")
    val dateTime: Date = Date.from(Instant.now())
){


}