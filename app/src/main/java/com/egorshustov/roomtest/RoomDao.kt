package com.egorshustov.roomtest

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface RoomDao {

    @Query("select * from records")
    fun getAllRecords(): List<Record>

    @Insert()
    fun insertRecord(record: Record)

    @Delete
    fun deleteRecord(record: Record)

}