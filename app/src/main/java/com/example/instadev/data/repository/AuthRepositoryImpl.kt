package com.example.instadev.data.repository

import com.example.instadev.data.datasource.api.ApiServices
import com.example.instadev.data.response.UserResponse
import com.example.instadev.data.response.toDomain
import com.example.instadev.domain.entity.UserEntity
import com.example.instadev.domain.repository.AuthRepository
import javax.inject.Inject
import javax.sql.DataSource

class AuthRepositoryImpl @Inject constructor(val api: ApiServices): AuthRepository {

    override fun doLogin(user: String, password: String): UserEntity {
        val userResponse: UserResponse = UserResponse("","","",10,listOf(""),0)

        return userResponse.toDomain()
    }
}