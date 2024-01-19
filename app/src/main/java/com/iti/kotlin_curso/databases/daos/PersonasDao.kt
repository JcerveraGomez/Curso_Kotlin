package com.iti.kotlin_curso.databases.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.iti.kotlin_curso.databases.entities.Persona

@Dao
interface PersonasDao {

    @Query("SELECT * FROM personas ORDER BY timestamp DESC")
    fun getAllPersonas(): LiveData<List<Persona>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPersona(gasto: Persona)

}