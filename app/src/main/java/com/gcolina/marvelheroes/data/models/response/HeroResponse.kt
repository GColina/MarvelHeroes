package com.gcolina.marvelheroes.data.models.response

import com.gcolina.marvelheroes.presentation.home.model.HeroModel
import com.google.gson.annotations.SerializedName

data class HeroResponse (
    @SerializedName("id")
    val id :Int,
    @SerializedName("name")
    val name :String,
){
    fun toDomain(): HeroModel {
        return HeroModel(
            id = id,
            name = name,
            appearanceCount = 0,
            image = ""
        )
    }
}