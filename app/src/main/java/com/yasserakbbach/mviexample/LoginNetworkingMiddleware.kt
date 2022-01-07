package com.yasserakbbach.mviexample

import com.yasserakbbach.mviexample.redux.Middleware
import com.yasserakbbach.mviexample.redux.Store
import com.yasserakbbach.mviexample.ui.login.LoginAction
import com.yasserakbbach.mviexample.ui.login.LoginViewState

class LoginNetworkingMiddleware(
    private val loginRepository: LoginRepository
) : Middleware<LoginViewState, LoginAction> {

    override suspend fun process(
        action: LoginAction,
        currentState: LoginViewState,
        store: Store<LoginViewState, LoginAction>
    ) {
        when(action) {
            is LoginAction.SignInButtonClicked -> {

                if(currentState.email.isEmpty()) {
                    store.dispatch(LoginAction.InvalidEmailSubmitted)
                    return
                }

                loginUser(store, currentState)
            }
        }
    }

    private suspend fun loginUser(
        store: Store<LoginViewState, LoginAction>,
        currentState: LoginViewState
    ) {
        store.dispatch(LoginAction.LoginStarted)

        val isSuccessful = loginRepository.login(
            email = currentState.email,
            password = currentState.password
        )

        if (isSuccessful) store.dispatch(LoginAction.LoginCompleted)
        else store.dispatch(LoginAction.LoginFailed(Throwable("Login failed")))
    }
}