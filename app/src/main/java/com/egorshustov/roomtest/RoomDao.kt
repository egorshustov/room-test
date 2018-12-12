package com.egorshustov.roomtest

import androidx.room.*

@Dao
interface RoomDao {

    @Insert()
    fun insertRecord(record: Record)

    @Query("select note from records WHERE id = :id")
    fun getOneRecord(id: Int): String

    @Query("select * from records")
    fun getAllRecords(): List<Record>

    @Update
    fun updateRecord(vararg record: Record)

    @Delete
    fun deleteByUserId(vararg record: Record)

    /*@Query("DELETE FROM records WHERE id = :id")
    fun deleteByUserId(id: Int)*/

}