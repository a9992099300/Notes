package com.a9992099300.notesmvvm.screens.note

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.a9992099300.notesmvvm.models.AppNote
import com.a9992099300.notesmvvm.utilits.REPOSITORY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteFragmentViewModel(application: Application): AndroidViewModel(application) {
    fun delete(note: AppNote, onSuccess:() ->Unit) =
            viewModelScope.launch(Dispatchers.IO) {
                REPOSITORY.delete(note){
                    viewModelScope.launch (Dispatchers.Main) {
                        onSuccess()
                    }
                }
            }

}