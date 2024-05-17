package org.food.recipe.recipeapp.presentation.views.screens.home.toolbar

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable


@Composable
fun ToolBarHeader() {
    Column {
        Text(
            text = "Hello there ...",
            color = MaterialTheme.colorScheme.tertiary,
            style = MaterialTheme.typography.labelMedium
        )
        Text(
            text = "What would you like \nto cook today ?",
            style = MaterialTheme.typography.titleLarge
        )
        ToolBarSearchBar()
    }
}