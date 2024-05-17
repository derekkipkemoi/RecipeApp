package org.food.recipe.recipeapp.data.dtos


import com.squareup.moshi.Json

data class Length(
    @Json(name = "number")
    val number: Int,
    @Json(name = "unit")
    val unit: String
)