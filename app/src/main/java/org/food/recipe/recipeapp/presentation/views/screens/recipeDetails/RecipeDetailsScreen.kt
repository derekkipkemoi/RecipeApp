package org.food.recipe.recipeapp.presentation.views.screens.recipeDetails

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import org.food.recipe.recipeapp.R

@Composable
fun RecipeDetailsScreen() {
    val items = (0..100).map {
        "Item $it"
    }
    val lazyListState = rememberLazyListState()
    var previousIndex by remember { mutableIntStateOf(lazyListState.firstVisibleItemIndex) }
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
        modifier = Modifier.fillMaxWidth()
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            AsyncImage(
                model = R.drawable.yoon_unsplash,
                contentDescription = "",
                modifier = Modifier.height(
                    when (value) {
                        true -> 250.dp
                        else -> 0.dp
                    }
                ),
                contentScale = ContentScale.FillWidth
            )
            Row(
                modifier = Modifier
                    .height(50.dp)
                    .background(
                        color = when (value) {
                            true -> Color.Transparent
                            else -> MaterialTheme.colorScheme.primary
                        }
                    )
                    .fillMaxWidth(), verticalAlignment = Alignment.Top
            ) {
                Text(text = "Hallo there")
            }
            LazyColumn(
                state = lazyListState, modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        top = when (value) {
                            true -> 200.dp
                            else -> 50.dp
                        }
                    )
                    .clip(shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                    .background(color = MaterialTheme.colorScheme.surface)

            ) {
                items(items.size) { item ->
                    Text(text = items[item], modifier = Modifier.padding(top = 20.dp))
                }
            }
        }

    }
}