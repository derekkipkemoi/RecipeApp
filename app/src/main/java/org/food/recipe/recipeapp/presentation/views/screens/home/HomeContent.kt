package org.food.recipe.recipeapp.presentation.views.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import org.food.recipe.recipeapp.presentation.viewModels.GetRecipesByMealTypeViewModel
import org.food.recipe.recipeapp.presentation.views.components.RecipeCard
import org.food.recipe.recipeapp.presentation.views.screens.home.toolbar.CollapsingToolbar

@Composable
fun HomeContent(
    getRecipesByMealTypeViewModel: GetRecipesByMealTypeViewModel = hiltViewModel()
) {

    val state by getRecipesByMealTypeViewModel.state.collectAsState()
    val lazyListState = rememberLazyGridState()
    var previousIndex by remember{ mutableIntStateOf(lazyListState.firstVisibleItemIndex) }
    var previousScrollOffset by remember { mutableIntStateOf(lazyListState.firstVisibleItemScrollOffset) }
    val value by remember {
        derivedStateOf {
            if (previousIndex != lazyListState.firstVisibleItemIndex) {
                previousIndex > lazyListState.firstVisibleItemIndex
            } else {
                previousScrollOffset >= lazyListState.firstVisibleItemScrollOffset
            }.also {
                previousIndex = lazyListState.firstVisibleItemIndex
                previousScrollOffset = lazyListState.firstVisibleItemScrollOffset
            }
        }
    }


    Column(
        modifier = Modifier.padding(start = 15.dp, end = 15.dp)
    ) {
        CollapsingToolbar(progress = value, onEvent = getRecipesByMealTypeViewModel::onEvent)
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            state = lazyListState
        ) {
            items(state.data.size) { item ->
                RecipeCard(recipe = state.data[item])
            }
        }
    }


}




