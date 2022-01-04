package com.yasserakbbach.mviexample.ui.login

import com.yasserakbbach.mviexample.redux.Reducer

class LoginReducer : Reducer<LoginViewState, LoginAction> {

    override fun reduce(currentState: LoginViewState, action: LoginAction): LoginViewState =
        when(action) {
            is LoginAction.EmailChanged -> stateWithNewEmail(currentState, action)
            is LoginAction.PasswordChanged -> stateWithNewPassword(currentState, action)
            is LoginAction.LoginStarted -> stateWithLoginStarted(currentState)
            is LoginAction.LoginCompleted -> stateWithLoginCompleted(currentState)
            is LoginAction.LoginFailed -> stateWithLoginFailed(currentState)
        }

    private fun stateWithNewEmail(
        currentState: LoginViewState,
        action: LoginAction.EmailChanged
    ) = currentState.copy(email = action.newEmail)

    private fun stateWithNewPassword(
        currentState: LoginViewState,
        action: LoginAction.PasswordChanged
    ) = currentState.copy(password = action.newPassword)

    private fun stateWithLoginStarted(currentState: LoginViewState) =
        currentState.copy(showProgressBar = true)

    private fun stateWithLoginCompleted(currentState: LoginViewState) =
        currentState.copy(showProgressBar = false)

    private fun stateWithLoginFailed(currentState: LoginViewState) =
        currentState.copy(showProgressBar = false)
}