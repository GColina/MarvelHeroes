package com.gcolina.marvelheroes.data.repository

import com.gcolina.marvelheroes.data.HeroApi
import com.gcolina.marvelheroes.data.models.response.HeroResponse
import com.gcolina.marvelheroes.utils.BaseDataSource
import javax.inject.Inject

class HeroesDataSource @Inject constructor(private val heroApi: HeroApi) : BaseDataSource() {
    suspend fun getHeroes(ts: Long, hash: String): Result<List<HeroResponse>> {
        return processResponse {
            heroApi.getHeroes(ts = ts, hash = hash)
        }
    }
}