package org.food.recipe.recipeapp.presentation.events


sealed interface RecipeAppEvents{
    class GetRecipesByMealType(val mealTypeName: String) : RecipeAppEvents
}