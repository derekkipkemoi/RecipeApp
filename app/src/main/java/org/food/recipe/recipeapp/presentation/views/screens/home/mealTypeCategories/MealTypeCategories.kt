package org.food.recipe.recipeapp.presentation.views.screens.home.mealTypeCategories

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.food.recipe.recipeapp.presentation.events.RecipeAppEvents
import org.food.recipe.recipeapp.presentation.views.components.MealTypeCategoryCard


@Composable
fun MealTypeCategories(
    onEvent: (RecipeAppEvents) -> Unit
) {
    val mealTypesList = listOf(
        MealTypesData.MainDish,
        MealTypesData.SideDish,
        MealTypesData.Dessert,
        MealTypesData.Appetizer,
        MealTypesData.Salad,
        MealTypesData.Bread,
        MealTypesData.BreakFast,
        MealTypesData.Soup,
        MealTypesData.Beverages,
        MealTypesData.Sauce,
        MealTypesData.Marinade,
        MealTypesData.FingerFood,
        MealTypesData.Snack,
        MealTypesData.Drink
    )
    Column {
        Text(
            text = "Categories", style = MaterialTheme.typography.titleMedium
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())
        ) {
            mealTypesList.forEach { type ->
                MealTypeCategoryCard(
                    mealTypeName = type.mealTypeName,
                    mealTypeIcon = type.mealTypeIcon,
                    onEvent = onEvent
                )
            }
        }
    }

}