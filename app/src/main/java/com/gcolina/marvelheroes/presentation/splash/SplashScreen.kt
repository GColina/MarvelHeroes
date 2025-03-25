package com.gcolina.marvelheroes.presentation.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.gcolina.marvelheroes.R
import com.gcolina.marvelheroes.core.navigation.Splash_Screen
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navigateToHome: () -> Unit) {

    LaunchedEffect(Unit) {
        delay(2000)
        navigateToHome()
    }

    Box(modifier = Modifier
        .background(colorScheme.primary)
        .fillMaxSize()) {
        Image(painter = painterResource(R.drawable.ic_logo), contentDescription = "")
    }

}