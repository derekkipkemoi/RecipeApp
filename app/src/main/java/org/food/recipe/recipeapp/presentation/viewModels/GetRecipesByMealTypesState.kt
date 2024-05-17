package org.food.recipe.recipeapp.presentation.viewModels

import org.food.recipe.recipeapp.data.dtos.Recipe
import org.food.recipe.recipeapp.utils.MealTypes

data class GetRecipesByMealTypesState(
    val data : List<Recipe> = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: String = "",
    val mealTypeName: String = MealTypes.MAIN_DISH.mealTypeName
)
