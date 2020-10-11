package com.example.notes.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.notes.data.NotesRepo

class MainViewModel : ViewModel() {
    val viewStateLiveData : MutableLiveData<MainViewState> = MutableLiveData()

    init {
        viewStateLiveData.value = MainViewState(NotesRepo.notes)
    }

    fun viewState(): LiveData<MainViewState> = viewStateLiveData
}