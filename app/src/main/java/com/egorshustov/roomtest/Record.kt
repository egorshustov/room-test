package com.egorshustov.roomtest

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "records")
data class Record(
    var note: String
){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    @Ignore
    constructor(id: Int, note: String) : this(note){
        this.id = id
    }
}