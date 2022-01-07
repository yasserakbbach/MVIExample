package com.yasserakbbach.mviexample

import android.util.Log
import com.yasserakbbach.mviexample.redux.Action
import com.yasserakbbach.mviexample.redux.Middleware
import com.yasserakbbach.mviexample.redux.State
import com.yasserakbbach.mviexample.redux.Store

/**
 * This [Middleware] is responsible for logging every [Action] that is processed to the Logcat, so
 * that we can use this for debugging.
 */
class LoggingMiddleware<S: State, A: Action> : Middleware<S, A> {

    override suspend fun process(action: A, currentState: S, store: Store<S, A>) {
        Log.d("LoggingMiddleware", "Processing action $action, current state: $currentState")
    }
}