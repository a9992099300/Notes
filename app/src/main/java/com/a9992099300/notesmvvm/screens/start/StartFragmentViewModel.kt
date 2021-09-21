package com.a9992099300.notesmvvm.screens.start

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.a9992099300.notesmvvm.database.firebase.AppFirebaseRepository
import com.a9992099300.notesmvvm.database.room.AppRoomDatabase
import com.a9992099300.notesmvvm.database.room.AppRoomRepository
import com.a9992099300.notesmvvm.utilits.REPOSITORY
import com.a9992099300.notesmvvm.utilits.TYPE_FIREBASE
import com.a9992099300.notesmvvm.utilits.TYPE_ROOM
import com.a9992099300.notesmvvm.utilits.showToast

class StartFragmentViewModel(application: Application): AndroidViewModel(application) {
    private val mContext = application

    fun initDatabase(type: String, onSuccess:() -> Unit){
        when(type){
            TYPE_ROOM ->{
                val dao = AppRoomDatabase.getInstance(mContext).getAppRoomDao()
                REPOSITORY = AppRoomRepository(dao)
                onSuccess()
            }

            TYPE_FIREBASE -> {
                REPOSITORY = AppFirebaseRepository()
                REPOSITORY.connectToDatabase({onSuccess()},{ showToast(it)})
            }

        }
    }
}