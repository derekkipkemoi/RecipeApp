package org.food.recipe.recipeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import dagger.hilt.android.AndroidEntryPoint
import org.food.recipe.recipeapp.presentation.views.screens.home.HomeScreen
import org.food.recipe.recipeapp.presentation.views.screens.recipeDetails.RecipeDetailsScreen
import org.food.recipe.recipeapp.presentation.views.ui.RecipeAppTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RecipeAppTheme {
                Surface {
                    HomeScreen()
//                 RecipeDetailsScreen()
                }
            }
        }
    }
}
