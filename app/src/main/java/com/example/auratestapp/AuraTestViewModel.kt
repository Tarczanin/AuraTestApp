package com.example.auratestapp


class AuraTestViewModel(
    val repository: AuraTestViewRepository
) : BaseViewModel<AuraTestScreenViewState, AuraTstScreenIntent>(AuraTestScreenViewState()) {

    fun initialize() {
        // todo download data from DB and set right view state
    }

    override fun publish(intent: AuraTstScreenIntent) {
        when (intent) {
            else -> {}
        }
    }
}

data class AuraTestScreenViewState(
    val screenViewState: AuraTestViewState = AuraTestViewState.InitViewState
)

sealed interface AuraTestViewState {
    object InitViewState : AuraTestViewState
}

sealed interface AuraTstScreenIntent {

}