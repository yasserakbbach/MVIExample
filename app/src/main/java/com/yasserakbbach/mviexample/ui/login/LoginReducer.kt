package com.yasserakbbach.mviexample.ui.login

import com.yasserakbbach.mviexample.redux.Reducer

/**
 * This reducer is responsible for handling any [LoginAction], and using that to create
 * a new [LoginViewState].
 */
class LoginReducer : Reducer<LoginViewState, LoginAction> {

    /**
     * Side note: Notice that all of the functions are named in a way that they signify they're
     * returning a new state, and not just processing information. This helps keep your when statements
     * clear that they're returning stuff, so that context isn't lost.
     */
    override fun reduce(currentState: LoginViewState, action: LoginAction): LoginViewState =
        when(action) {
            is LoginAction.EmailChanged -> stateWithNewEmail(currentState, action)
            is LoginAction.PasswordChanged -> stateWithNewPassword(currentState, action)
            is LoginAction.LoginStarted -> stateWithLoginStarted(currentState)
            is LoginAction.LoginCompleted -> stateWithLoginCompleted(currentState)
            is LoginAction.LoginFailed -> stateWithLoginFailed(currentState)
            is LoginAction.InvalidEmailSubmitted -> stateWithInvalidEmailSubmitted(currentState)
            else -> currentState
        }

    private fun stateWithInvalidEmailSubmitted(currentState: LoginViewState) =
        currentState.copy(
            emailError = "Invalid email"
        )

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