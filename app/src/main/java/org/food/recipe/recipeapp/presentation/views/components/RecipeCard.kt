package org.food.recipe.recipeapp.presentation.views.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import org.food.recipe.recipeapp.R
import org.food.recipe.recipeapp.data.dtos.Recipe

@Composable
fun RecipeCard(
    recipe: Recipe
) {
    Column(
        modifier = Modifier.padding(5.dp)
    ) {
        Box() {
            AsyncImage(
                model = recipe.image, contentDescription = "recipe image",
                modifier = Modifier.clip(shape = RoundedCornerShape(20.dp)),
                contentScale = ContentScale.FillBounds
            )
            Row(
                modifier = Modifier
                    .padding(10.dp)
                    .clip(shape = RoundedCornerShape(8.dp))
                    .background(color = MaterialTheme.colorScheme.tertiary),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.time),
                    contentDescription = "time to cook",
                    modifier = Modifier.width(22.dp).padding(3.dp),
                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.surface)
                )
                Text(
                    text = recipe.readyInMinutes.toString() + " mins",
                    modifier = Modifier.padding(4.dp),
                    color = MaterialTheme.colorScheme.surface,
                    style = MaterialTheme.typography.labelSmall
                )
            }
        }
        Text(
            text = recipe.title,
            style = MaterialTheme.typography.titleMedium
        )
    }
}