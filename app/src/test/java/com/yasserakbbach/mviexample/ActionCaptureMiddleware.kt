package com.yasserakbbach.mviexample


import com.google.common.truth.Truth.assertThat
import com.yasserakbbach.mviexample.redux.Action
import com.yasserakbbach.mviexample.redux.Middleware
import com.yasserakbbach.mviexample.redux.State
import com.yasserakbbach.mviexample.redux.Store

/**
 * This is a implementation of [Middleware] that will log every action sent to it.
 *
 * In a unit test, we can apply this middleware to a Store, and then use this middleware for asserting
 * that an action was sent to that store.
 */
class ActionCaptureMiddleware<S: State, A: Action> : Middleware<S, A> {
    private val actionHistory: MutableList<Action> = mutableListOf()

    override suspend fun process(action: A, currentState: S, store: Store<S, A>) {
        actionHistory.add(action)
    }

    fun assertActionProcessed(expectedAction: Action) {
        assertThat(actionHistory).contains(expectedAction)
    }
}