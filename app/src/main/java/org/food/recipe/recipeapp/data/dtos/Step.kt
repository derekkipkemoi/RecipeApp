package org.food.recipe.recipeapp.data.dtos


import com.squareup.moshi.Json

data class Step(
    @Json(name = "equipment")
    val equipment: List<Equipment>,
    @Json(name = "ingredients")
    val ingredients: List<Ingredient>,
    @Json(name = "length")
    val length: Length,
    @Json(name = "number")
    val number: Int,
    @Json(name = "step")
    val step: String
)