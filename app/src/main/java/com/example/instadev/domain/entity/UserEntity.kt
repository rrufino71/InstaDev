package com.example.instadev.domain.entity

data class UserEntity (
    val userId:String,
    val name:String,
    val nickName: String,
    val followers:Int,
    val following: List<String>,
    val userMode: UserMode
)

sealed class UserMode(val userType:Int) {
    object REGULAR_USER:UserMode(0)
    object CONTENT_CREATOR_USER:UserMode(1)
    object COMPANY_USER:UserMode(2)
}