package com.yasserakbbach.mviexample

interface LoginRepository {
    fun login(email: String, password: String): Boolean
}