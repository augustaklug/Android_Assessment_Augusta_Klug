package com.example.assessmentaugusta.ui.about

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AboutViewModel : ViewModel() {

    private val _titleText = MutableLiveData<String>().apply {
        value = "Sobre o aplicativo"
    }

    private val _descriptionText = MutableLiveData<String>().apply {
        value = "Aplicativo desenvolvido para o Assessment das disciplinas Desenvolvimento de Interfaces Android e Fundamentos do Desenvolvimento Android"
    }

    val titleText: LiveData<String> = _titleText
    val descriptionText: LiveData<String> = _descriptionText
}