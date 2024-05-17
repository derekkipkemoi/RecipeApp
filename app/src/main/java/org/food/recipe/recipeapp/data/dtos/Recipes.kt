package org.food.recipe.recipeapp.data.dtos


import com.squareup.moshi.Json

data class Recipes(
    @Json(name = "recipes")
    val recipes: List<Recipe>
)