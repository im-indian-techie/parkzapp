package com.example.parkzapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.parkzapp.model.pojo.UserData
import com.example.parkzapp.model.repository.DashboardRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(private val repository: DashboardRepository):ViewModel() {
    val data: LiveData<List<UserData.Data>> get() =repository.userData
    val error:LiveData<String> get()= repository.errorData
    val isLoading:LiveData<Boolean> get() = repository.isLoading


    fun fetchData() {
        viewModelScope.launch(Dispatchers.Main) {
           repository.fetchData()
        }
    }

}