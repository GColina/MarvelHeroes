package com.gcolina.marvelheroes.data

import com.gcolina.marvelheroes.data.models.response.HeroResponse
import com.gcolina.marvelheroes.utils.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface HeroApi {
    @GET(Constants.GET_LIST_HEROES)
    suspend fun getHeroes(
        @Query("ts") ts: Long,
        @Query("apikey") apikey: String = Constants.API_KEY_PUBLIC,
        @Query("hash") hash: String,
        @Header("Accept") accept: String = "*/*"
    ): Response<List<HeroResponse>>

}