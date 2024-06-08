package com.example.parkzapp.model.api

import com.example.parkzapp.model.pojo.UserData
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET(APIConstants.USERS_DATA)
    suspend fun fetchUserData(): Response<UserData>
}