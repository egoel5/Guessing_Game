package com.example.c323_midtermproject

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "score_table")
data class Score(
    @PrimaryKey(autoGenerate = true)
    var scoreId: Long = 0L,
    @ColumnInfo(name = "score_user")
    var scoreUser: String = "",
    @ColumnInfo(name = "score_num")
    var scoreNum: String = ""
)
