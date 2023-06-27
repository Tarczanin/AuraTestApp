package com.example.auratestapp

import androidx.annotation.AnyThread
import androidx.annotation.MainThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel<State : Any, Intent : Any>(private val initialState: State) : ViewModel() {

    private val currentViewState get() = viewState.value ?: initialState

    private val _viewState = MutableLiveData(initialState)
    val viewState: LiveData<State> = _viewState

    @MainThread
    open fun publish(intent: Intent) {
    }

    @MainThread
    protected fun setState(reducer: (State) -> State) {
        _viewState.value = reducer(currentViewState)
    }

    @AnyThread
    protected fun postState(reducer: (State) -> State) {
        _viewState.postValue(reducer(currentViewState))
    }
}
