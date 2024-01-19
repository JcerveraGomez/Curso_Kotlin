package com.iti.kotlin_curso.databases.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iti.kotlin_curso.databases.entities.Persona
import com.iti.kotlin_curso.databases.repositories.PersonasRepository
import kotlinx.coroutines.launch

class PersonasViewModel(private val repository: PersonasRepository) : ViewModel() {
    var allPersonas: LiveData<List<Persona>> = repository.allPersonas

    fun insert(persona: Persona) = viewModelScope.launch {
        repository.insert(persona)
    }
    fun update(persona: Persona) = viewModelScope.launch {
        repository.update(persona)

    }
    fun delete(uuid:String) = viewModelScope.launch {
        repository.delete(uuid)
    }

}