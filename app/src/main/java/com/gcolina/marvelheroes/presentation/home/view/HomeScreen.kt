package com.gcolina.marvelheroes.presentation.home.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.gcolina.marvelheroes.R
import com.gcolina.marvelheroes.presentation.home.view.viewComponents.ItemHero
import com.gcolina.marvelheroes.presentation.home.viewModel.HomeViewModel

@Composable
fun HomeScreen(navigateToDetail: () -> Unit, homeViewModel: HomeViewModel = hiltViewModel()) {

    LaunchedEffect(Unit) {
        homeViewModel.fetchData()
    }

    val uiState by homeViewModel.uiState.collectAsState()


    Column(
        modifier = Modifier
            .background(colorScheme.primary)
            .fillMaxSize()
            .padding(dimensionResource(R.dimen.big_padding))
    ) {

        Image(
            painter = painterResource(R.drawable.ic_logo),
            contentDescription = null,
            modifier = Modifier
                .padding()
                .height(50.dp)
                .fillMaxWidth(),
            alignment = Alignment.TopCenter
        )
        Spacer(Modifier.height(dimensionResource(R.dimen.big_padding)))
        Text(
            text = stringResource(R.string.home_title_heroes),
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        )

        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(uiState.heroes.size) { position ->
                ItemHero(heroModel = uiState.heroes[position])
            }
        }
    }


}
