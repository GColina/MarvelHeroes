package com.gcolina.marvelheroes.presentation.detail.viewModel

import androidx.lifecycle.ViewModel
import com.gcolina.marvelheroes.presentation.home.model.HeroModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(): ViewModel(){

    private var _uiState = MutableStateFlow(DetailUiState())
    val uiState: StateFlow<DetailUiState> = _uiState

    fun getHeroById(id: Int) {
        // Tengo que ejecutar la llamada, esperar que funcione la url

        isLoading(true)




        //Despues de la llamada
        isLoading(false)
    }

    fun isLoading(isLoading: Boolean) {
        _uiState.value = _uiState.value.copy(isLoading = isLoading)

    }


}

data class DetailUiState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val hero: HeroModel? = null
)