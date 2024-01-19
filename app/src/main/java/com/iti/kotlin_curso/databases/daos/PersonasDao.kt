package com.iti.kotlin_curso.databases.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.iti.kotlin_curso.databases.entities.Persona

@Dao
interface PersonasDao {

    @Query("SELECT * FROM personas ORDER BY timestamp DESC")
    fun getAllPersonas(): LiveData<List<Persona>>

    @Query("DELETE FROM personas WHERE uuid = :uuid")
    suspend fun deletePersonaByUuid(uuid: String)
    @Update
    suspend fun updatePersona(persona: Persona): Int
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPersona(gasto: Persona)

}