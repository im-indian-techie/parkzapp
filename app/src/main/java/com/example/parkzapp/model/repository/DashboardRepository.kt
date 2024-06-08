package com.example.parkzapp.model.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.parkzapp.model.api.ApiService
import com.example.parkzapp.model.pojo.UserData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class DashboardRepository @Inject constructor(private val apiService: ApiService) {
    private val _isLoading= MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
        get()=  _isLoading

    private val _userData= MutableLiveData<List<UserData.Data>>()
    val userData: LiveData<List<UserData.Data>>
        get() = _userData

    private val _errorData= MutableLiveData<String>()
    val errorData: LiveData<String> get() = _errorData

    suspend fun fetchData()
    {
        _isLoading.value=true
        try {
            val response=apiService.fetchUserData()
            if(response.isSuccessful && response.body()!=null)
            {
                _isLoading.value=false
                if(response.body()!!.data.size>0)
                {
                    _userData.value=response.body()!!.data
                }
                else
                {
                    _errorData.value="No data found"
                }
            }
            else
            {
                _isLoading.value=false
                _errorData.value="some error occurred"
            }
        } catch (e: Exception) {
            _isLoading.value=false
            _errorData.value="some error occurred"
        }
    }
}