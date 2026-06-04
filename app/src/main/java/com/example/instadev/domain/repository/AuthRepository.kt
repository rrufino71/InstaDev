package com.example.instadev.domain.repository

import com.example.instadev.domain.entity.UserEntity

interface AuthRepository {
    suspend fun doLogin(user:String, password:String): List<UserEntity>
}