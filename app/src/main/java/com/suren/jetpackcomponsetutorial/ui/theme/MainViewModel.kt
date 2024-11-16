package com.suren.jetpackcomponsetutorial.ui.theme

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val nameState = MutableLiveData("")

    fun onTextChanged(newString: String) {
        nameState.value = newString
    }
}