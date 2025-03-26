package com.gcolina.marvelheroes.data.repository

import com.gcolina.marvelheroes.data.models.response.HeroResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class HeroesRepositoryImpl @Inject constructor(private val heroesDataSource: HeroesDataSource) :
    HeroesRepository {
    override suspend fun getHeroes(ts: Long, hash: String): Flow<Result<List<HeroResponse>>> =
        flow {
            emit(heroesDataSource.getHeroes(ts = ts, hash = hash))
        }

}