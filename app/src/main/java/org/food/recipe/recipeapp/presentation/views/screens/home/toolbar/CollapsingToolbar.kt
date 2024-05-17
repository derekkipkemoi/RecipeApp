package org.food.recipe.recipeapp.presentation.views.screens.home.toolbar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.food.recipe.recipeapp.presentation.events.RecipeAppEvents
import org.food.recipe.recipeapp.presentation.views.screens.home.mealTypeCategories.MealTypeCategories
import kotlin.reflect.KFunction1

private val MaxHeight = 255.dp
private val MinHeight = 100.dp

@Composable
fun CollapsingToolbar(
    progress: Boolean,
    onEvent: (RecipeAppEvents) -> Unit
) {
    Column(
        modifier = Modifier
            .padding(top = 10.dp, bottom = 5.dp)
            .fillMaxWidth()
            .height(
                when (progress) {
                    true -> MaxHeight
                    false -> MinHeight
                }
            ),
        verticalArrangement = Arrangement.Center
    ) {
        if (progress) {
            ToolBarHeader()
        }
        MealTypeCategories(onEvent = onEvent)
    }
}


