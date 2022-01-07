package com.yasserakbbach.mviexample

interface LoginRepository {
    suspend fun login(email: String, password: String): Boolean
}