package org.food.recipe.recipeapp.domain.use_cases

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.food.recipe.recipeapp.data.dtos.Recipes
import org.food.recipe.recipeapp.domain.repositories.RecipeAppRepository
import org.food.recipe.recipeapp.utils.Resource
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetRecipesByMealTypeUseCase @Inject constructor(private val recipeAppRepository: RecipeAppRepository) {
    operator fun invoke(
        recipesNumber: Int,
        recipeMealTypeTag: String,
        apiKey: String
    ): Flow<Resource<Recipes>> = flow {
        try {
            emit(Resource.Loading(true))
            val data = recipeAppRepository.getRecipesByMealType(recipesNumber,recipeMealTypeTag, apiKey)
            emit(Resource.Success(data))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "Unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage ?: "Check your internet connection"))
        }
    }
}