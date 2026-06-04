package com.example.instadev.data.repository

import android.util.Log
import com.example.instadev.data.datasource.api.ApiServices
import com.example.instadev.data.response.UserResponse
import com.example.instadev.data.response.toDomain
import com.example.instadev.domain.entity.UserEntity
import com.example.instadev.domain.repository.AuthRepository
import javax.inject.Inject
import javax.sql.DataSource

class AuthRepositoryImpl @Inject constructor(val api: ApiServices): AuthRepository {

    override suspend fun doLogin(user: String, password: String): List<UserEntity> {
        //return userResponse.toDomain()
        val response = try {
            api.doLogin()
        } catch (e: Exception) {
            Log.i("dologin error", "$e")
            listOf()
        }
        return response.map { it.toDomain() }
    }
}