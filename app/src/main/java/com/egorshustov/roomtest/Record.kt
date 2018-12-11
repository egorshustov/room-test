package com.egorshustov.roomtest

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "records")
data class Record(
    var note: String
){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}