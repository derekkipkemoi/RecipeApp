package org.food.recipe.recipeapp.data.remote

import org.food.recipe.recipeapp.data.dtos.Recipes
import retrofit2.http.GET
import retrofit2.http.Query

interface RecipeAppApi {
    @GET("random/")
    suspend fun getRecipeListByMealType(
        @Query("number") recipeNumber: Int,
        @Query("tags") recipeMealTypeTag: String,
        @Query("apiKey") apiKey: String
    ): Recipes
}