package com.a9992099300.notesmvvm.screens.add_new_note

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.a9992099300.notesmvvm.models.AppNote
import com.a9992099300.notesmvvm.utilits.REPOSITORY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.DisposableHandle
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AddNewNoteViewModel(application: Application):AndroidViewModel(application){

    fun insert(note:AppNote, onSuccess: () -> Unit) =

            viewModelScope.launch (Dispatchers.IO) {
                REPOSITORY.insert(note){
                    viewModelScope.launch (Dispatchers.Main) {
                        onSuccess()
                    }
                }
           }
}