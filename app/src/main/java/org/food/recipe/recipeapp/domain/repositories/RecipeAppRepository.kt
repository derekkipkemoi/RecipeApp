package org.food.recipe.recipeapp.domain.repositories

import org.food.recipe.recipeapp.data.dtos.Recipes

interface RecipeAppRepository {
    suspend fun getRecipesByMealType(recipesNumber : Int, recipeMealTypeTag : String, apiKey : String ) : Recipes

}