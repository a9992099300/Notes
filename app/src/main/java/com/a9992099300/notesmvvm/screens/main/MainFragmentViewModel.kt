package com.a9992099300.notesmvvm.screens.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.a9992099300.notesmvvm.utilits.REPOSITORY

class MainFragmentViewModel(application: Application): AndroidViewModel(application) {
    val allNotes = REPOSITORY.allNotes
    fun signOut(){
        REPOSITORY.signOut()
    }
}