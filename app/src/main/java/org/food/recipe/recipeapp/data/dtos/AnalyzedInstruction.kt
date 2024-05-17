package org.food.recipe.recipeapp.data.dtos


import com.squareup.moshi.Json

data class AnalyzedInstruction(
    @Json(name = "name")
    val name: String,
    @Json(name = "steps")
    val steps: List<Step>
)