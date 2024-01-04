package com.iti.kotlin_curso.databases.repositories

import androidx.lifecycle.LiveData
import com.iti.kotlin_curso.databases.daos.PersonasDao
import com.iti.kotlin_curso.databases.entities.Persona

class PersonasRepository(private val personasDao: PersonasDao) {

    val allPersonas: LiveData<List<Persona>> = personasDao.getAllPersonas()
    suspend fun insert(persona: Persona) {
        personasDao.insertPersona(persona)
    }
}