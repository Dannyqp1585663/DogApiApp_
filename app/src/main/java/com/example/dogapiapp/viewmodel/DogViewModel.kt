package com.example.dogapiapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dogapiapp.model.DogApiResponse
import com.example.dogapiapp.network.RetrofitInstance
import kotlinx.coroutines.launch
class DogViewModel : ViewModel() {
    private val _dogImage = MutableLiveData<DogApiResponse?>()
    val dogImage: LiveData<DogApiResponse?> = _dogImage
    fun getRandomDogImage() {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getRandomDogImage()
                if (response.isSuccessful) {
                    _dogImage.postValue(response.body())
                } else {
                    _dogImage.postValue(null) // Manejo de error
                }
            } catch (e: Exception) {
                _dogImage.postValue(null) // Manejo de excepción
            }
        }
    }
}