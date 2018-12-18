package com.egorshustov.roomtest

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.room.migration.Migration



@Entity(tableName = "records")
data class Record(
    var note: String,
    var subnote: String
){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    @Ignore
    constructor(id: Int, note: String, subnote: String) : this(note, subnote){
        this.id = id
    }
}