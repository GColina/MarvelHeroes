package com.gcolina.marvelheroes.presentation.home.view.viewComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.gcolina.marvelheroes.presentation.home.model.HeroModel


@Composable
fun ItemHero(heroModel: HeroModel) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
    ) {
        val imagePainter = rememberAsyncImagePainter(model = heroModel.image)

        Row(Modifier.fillMaxSize()) {
            Image(
                painter = imagePainter,
                contentDescription = null,
                modifier = Modifier.weight(0.4f),
                contentScale = ContentScale.Crop,
            )
            Column(modifier = Modifier.weight(0.6f),) {
                Text(text = heroModel.name)
                Text(text = heroModel.appearanceCount.toString())
            }

        }
    }
}