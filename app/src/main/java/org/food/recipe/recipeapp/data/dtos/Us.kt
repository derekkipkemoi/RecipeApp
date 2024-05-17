package org.food.recipe.recipeapp.data.dtos


import com.squareup.moshi.Json

data class Us(
    @Json(name = "amount")
    val amount: Double,
    @Json(name = "unitLong")
    val unitLong: String,
    @Json(name = "unitShort")
    val unitShort: String
)