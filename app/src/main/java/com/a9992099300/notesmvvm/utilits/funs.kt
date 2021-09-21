package com.a9992099300.notesmvvm.utilits

import android.widget.Toast

fun showToast(message: String){
    Toast.makeText(APP_ACTIVITY, message, Toast.LENGTH_LONG).show()
}