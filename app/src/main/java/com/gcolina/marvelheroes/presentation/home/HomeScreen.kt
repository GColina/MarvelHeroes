package com.gcolina.marvelheroes.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.gcolina.marvelheroes.presentation.home.viewModel.HomeViewModel

@Composable
fun HomeScreen(navigateToDetail: () -> Unit, homeViewModel: HomeViewModel = hiltViewModel()) {

    Column(
        modifier = Modifier
            .background(colorScheme.primary)
            .fillMaxSize()
    ) {

        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(R.drawable.ic_logo),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(vertical = dimensionResource(R.dimen.big_padding))
                    .height(50.dp)
            )

            Image(
                painter = painterResource(R.drawable.bg_login_image),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(dimensionResource(R.dimen.mid_padding))
                    .height(80.dp)
            )
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = dimensionResource(R.dimen.mid_padding))
        ) {
            Column(
                modifier = Modifier.padding(dimensionResource(R.dimen.mid_padding))
            ) {
                Text(
                    text = stringResource(R.string.home_title_heroes),
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                )
            }

        }
    }
}