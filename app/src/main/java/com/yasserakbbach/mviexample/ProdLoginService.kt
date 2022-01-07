package com.yasserakbbach.mviexample

class ProdLoginService : LoginRepository {

    override fun login(email: String, password: String): Boolean = true
}