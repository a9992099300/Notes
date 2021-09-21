package com.a9992099300.notesmvvm.database

import androidx.lifecycle.LiveData
import com.a9992099300.notesmvvm.models.AppNote

interface DatabaseRepository {
    val allNotes: LiveData<List<AppNote>>
    suspend fun insert(note: AppNote, onSuccess:()-> Unit)
    suspend fun delete(note: AppNote, onSuccess:()-> Unit)

    fun connectToDatabase(onSuccess: () -> Unit, onFail: (String) -> Unit){}

    fun signOut(){}
}