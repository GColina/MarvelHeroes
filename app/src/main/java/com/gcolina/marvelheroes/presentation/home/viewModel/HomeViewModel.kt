package com.gcolina.marvelheroes.presentation.home.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gcolina.marvelheroes.data.repository.HeroesRepository
import com.gcolina.marvelheroes.presentation.home.model.HeroModel
import com.gcolina.marvelheroes.utils.Constants
import com.gcolina.marvelheroes.utils.md5
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val heroesRepository: HeroesRepository
) : ViewModel() {

    private var _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState


    fun fetchData() {

        val ts = 1L
        /*val ts = System.currentTimeMillis()*/
        val hash = md5(ts.toString() + Constants.API_KEY_PRIVATE + Constants.API_KEY_PUBLIC)
        viewModelScope.launch {
            heroesRepository.getHeroes(ts, hash).collect { result ->
                result.onSuccess { list ->
                    _uiState.update { it.copy(heroes = list.map { item -> item.toDomain() }) }
                }.onFailure {
                    Log.e("LogGeneral", "fetchData: ${it.message}")
                }
            }
        }
        /*val image =
            "https://imgs.search.brave.com/HFfCS_WfM5Pl7WkpyJ6C3Nn_YEYNCtahNFpRtKP_3CI/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly91cGxv/YWQud2lraW1lZGlh/Lm9yZy93aWtpcGVk/aWEvY29tbW9ucy90/aHVtYi81LzUyL1Nw/aWRlci1NYW4uanBn/LzUxMnB4LVNwaWRl/ci1NYW4uanBn"
        _uiState.update {
            it.copy(
                heroes = listOf(
                    HeroModel(
                        id = 1, image = image, name = "Superman", appearanceCount = 120
                    ), HeroModel(
                        id = 2, image = image, name = "Batman", appearanceCount = 150
                    ), HeroModel(
                        id = 3, image = image, name = "Wonder Woman", appearanceCount = 100
                    ), HeroModel(
                        id = 4, image = image, name = "Spider-Man", appearanceCount = 200
                    ), HeroModel(
                        id = 5, image = image, name = "Iron Man", appearanceCount = 180
                    )
                )
            )
        }*/
    }


}

data class HomeUiState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val heroes: List<HeroModel> = emptyList()
)