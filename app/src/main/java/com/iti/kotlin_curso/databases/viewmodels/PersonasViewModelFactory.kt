package com.iti.kotlin_curso.databases.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.iti.kotlin_curso.databases.repositories.PersonasRepository

class PersonasViewModelFactory(private val repository: PersonasRepository): ViewModelProvider.Factory  {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PersonasViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return PersonasViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}