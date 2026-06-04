package com.example.instadev.data.response

import com.example.instadev.domain.entity.UserEntity
import com.example.instadev.domain.entity.UserMode
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserResponse(
    //@Serialname es el nombre en el response
    @SerialName("userId") val userId:String,
    @SerialName("name") val name:String,
    @SerialName("nickname") val nickname: String,
    @SerialName("followers") val followers:Int=0, //no requerido si lo inicializo
    @SerialName("following") val following: List<String> = emptyList(),
    @SerialName("userType") val userType: Int
)

fun UserResponse.toDomain(): UserEntity {

    val userMode = when(userType) {
        UserMode.REGULAR_USER.userType -> UserMode.REGULAR_USER
        UserMode.CONTENT_CREATOR_USER.userType -> UserMode.CONTENT_CREATOR_USER
        UserMode.COMPANY_USER.userType -> UserMode.COMPANY_USER
        else -> UserMode.REGULAR_USER
    }


    return UserEntity(
        userId = userId,
        name = name,
        nickName = nickname,
        followers = followers,
        following = following,
        userMode = userMode

    )
}