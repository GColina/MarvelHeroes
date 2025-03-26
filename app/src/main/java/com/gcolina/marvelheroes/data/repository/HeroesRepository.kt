package com.gcolina.marvelheroes.data.repository

import com.gcolina.marvelheroes.data.models.response.HeroResponse
import kotlinx.coroutines.flow.Flow

interface HeroesRepository {
    suspend fun getHeroes(ts: Long, hash: String): Flow<Result<List<HeroResponse>>>
}