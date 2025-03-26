package com.gcolina.marvelheroes.presentation.home.viewModel

import androidx.lifecycle.ViewModel
import com.gcolina.marvelheroes.presentation.home.model.HeroModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {

    private var _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState


    fun fetchData() {
        val image =
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
        }
    }


}

data class HomeUiState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val heroes: List<HeroModel> = emptyList()
)