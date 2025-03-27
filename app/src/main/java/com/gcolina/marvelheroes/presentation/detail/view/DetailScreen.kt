package com.gcolina.marvelheroes.presentation.detail.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.gcolina.marvelheroes.presentation.detail.viewModel.DetailViewModel


@Composable
fun DetailScreen(detailViewModel: DetailViewModel = hiltViewModel(), onBackPressed: () -> Boolean) {

    val uiState by detailViewModel.uiState.collectAsState()
    val context = LocalContext.current
    LaunchedEffect(Unit) {
        //Id hardcoded para probar
        val heroId = 1
        detailViewModel.getHeroById(heroId)
    }

    Column(modifier = Modifier.fillMaxSize()) {
        AsyncImage(
            model = ImageRequest.Builder(context).scale(scale = coil.size.Scale.FILL)
                .data(uiState.hero?.image).crossfade(true).build(),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            contentScale = ContentScale.Crop,
        )
        Text(text = uiState.hero?.name ?: "")

        Text(text = uiState.hero?.appearanceCount.toString())

    }

}
