package org.food.recipe.recipeapp.data.repositories

import org.food.recipe.recipeapp.data.dtos.Recipes
import org.food.recipe.recipeapp.data.remote.RecipeAppApi
import org.food.recipe.recipeapp.domain.repositories.RecipeAppRepository
import javax.inject.Inject

class RecipesAppRepositoriesImpl @Inject constructor(private val recipeAppApi: RecipeAppApi) :
    RecipeAppRepository {
    override suspend fun getRecipesByMealType(
        recipesNumber: Int,
        recipeMealTypeTag: String,
        apiKey: String
    ): Recipes =
        recipeAppApi.getRecipeListByMealType(recipesNumber, recipeMealTypeTag, apiKey)

}