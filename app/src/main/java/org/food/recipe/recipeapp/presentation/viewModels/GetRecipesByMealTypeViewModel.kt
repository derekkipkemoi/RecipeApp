package org.food.recipe.recipeapp.presentation.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import org.food.recipe.recipeapp.domain.use_cases.GetRecipesByMealTypeUseCase
import org.food.recipe.recipeapp.presentation.events.RecipeAppEvents
import org.food.recipe.recipeapp.utils.Constants
import org.food.recipe.recipeapp.utils.MealTypes
import org.food.recipe.recipeapp.utils.Resource
import javax.inject.Inject

@HiltViewModel
class GetRecipesByMealTypeViewModel @Inject constructor(private val getRecipesByMealTypeUseCase: GetRecipesByMealTypeUseCase) :
    ViewModel() {
    private val _state = MutableStateFlow(GetRecipesByMealTypesState())
    val state = _state.asStateFlow()

    init {
        getRecipesByMealType(
            _state.value.mealTypeName
        )
    }

    fun onEvent(event: RecipeAppEvents) {
        when (event) {
            is RecipeAppEvents.GetRecipesByMealType -> {
                _state.update {
                    it.copy(
                        mealTypeName = event.mealTypeName
                    )
                }
                getRecipesByMealType(
                    _state.value.mealTypeName
                )
            }
        }
    }

    private fun getRecipesByMealType(
        recipeMealTypeTag: String
    ) {
        getRecipesByMealTypeUseCase(
            Constants.API_NUMBER_LIMIT,
            recipeMealTypeTag,
            Constants.SPOONACULAR_API_KEY
        ).onEach { results ->
            when (results) {
                is Resource.Success -> {
                    _state.update {
                        it.copy(
                            data = results.data!!.recipes
                        )
                    }
                }

                is Resource.Loading -> {
                    _state.update {
                        it.copy(
                            isLoading = results.isLoading
                        )
                    }
                }

                is Resource.Error -> {
                    _state.update {
                        it.copy(
                            errorMessage = results.errorMessage ?: "Unexpected error occurred"
                        )
                    }
                }
            }
        }.launchIn(viewModelScope)
    }
}