package com.example.instadev.domain.usecase

import com.example.instadev.domain.entity.UserEntity
import com.example.instadev.domain.repository.AuthRepository
import javax.inject.Inject


class Login @Inject constructor(private val authRepository: AuthRepository
    ) {
    //suspend es porque es asincronico va en corutinas
    suspend operator fun invoke(user:String, password:String): UserEntity? {
        if(user.contains("hotmail.com")) {
            return null
        }
        val response = authRepository.doLogin(user,password)
        return response.random()
    }
}