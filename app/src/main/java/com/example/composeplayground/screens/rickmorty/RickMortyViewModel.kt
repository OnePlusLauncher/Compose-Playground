package com.example.composeplayground.screens.rickmorty

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composeplayground.screens.rickmorty.data.Character
import com.example.composeplayground.screens.rickmorty.data.RickMortyRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*

class RickMortyViewModel(
    repository: RickMortyRepository
) : ViewModel() {

    private val triggerFlow = MutableStateFlow(true)

    val state: StateFlow<RickMortyState> = triggerFlow.flatMapConcat {
        flow {
            delay(2000)
            emit(
                try {
                    RickMortyState.Success(repository.getCharacters())
                } catch (throwable: Throwable) {
                    RickMortyState.Error
                }
            )
        }
    }.stateIn(viewModelScope, SharingStarted.Lazily, RickMortyState.Loading)

    fun retry() {
    }
}

sealed class RickMortyState {
    object Loading : RickMortyState()
    data class Success(val characters: List<Character>) : RickMortyState()
    object Error : RickMortyState()
}