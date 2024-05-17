package org.food.recipe.recipeapp.presentation.views.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import org.food.recipe.recipeapp.presentation.events.RecipeAppEvents
import org.food.recipe.recipeapp.presentation.viewModels.GetRecipesByMealTypeViewModel

@Composable
fun MealTypeCategoryCard(
    mealTypeName: String, mealTypeIcon: Int,
    onEvent: (RecipeAppEvents) -> Unit,
    getRecipesByMealTypeViewModel: GetRecipesByMealTypeViewModel = hiltViewModel()
) {
    val state by getRecipesByMealTypeViewModel.state.collectAsState()
    Column(
        modifier = Modifier
            .padding(end = 10.dp)
            .width
                (80.dp)
            .height(70.dp)
            .background(
                color = when (mealTypeName) {
                    state.mealTypeName -> MaterialTheme.colorScheme.primary
                    else -> MaterialTheme.colorScheme.surface
                },
                shape = RoundedCornerShape(10.dp)
            )
            .clickable {
                onEvent(RecipeAppEvents.GetRecipesByMealType(mealTypeName))
            },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = mealTypeIcon),
            contentDescription = "",
            alignment = Alignment.Center,
            modifier = Modifier
                .height(35.dp)
                .width(35.dp)
                .padding(top = 5.dp),
        )
        Text(
            text = mealTypeName,
            color = when (mealTypeName) {
                state.mealTypeName -> MaterialTheme.colorScheme.surface
                else -> MaterialTheme.colorScheme.tertiary
            },
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.labelMedium
        )
    }
}