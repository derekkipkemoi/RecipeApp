package org.food.recipe.recipeapp.data.dtos


import com.squareup.moshi.Json

data class Measures(
    @Json(name = "metric")
    val metric: Metric,
    @Json(name = "us")
    val us: Us
)