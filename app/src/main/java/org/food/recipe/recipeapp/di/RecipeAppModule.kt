package org.food.recipe.recipeapp.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.food.recipe.recipeapp.data.remote.RecipeAppApi
import org.food.recipe.recipeapp.data.repositories.RecipesAppRepositoriesImpl
import org.food.recipe.recipeapp.domain.repositories.RecipeAppRepository
import org.food.recipe.recipeapp.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RecipeAppModule {

    @Provides
    @Singleton
    fun provideRecipeAppApi() : RecipeAppApi =
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URl)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(RecipeAppApi::class.java)

    @Provides
    @Singleton
    fun provideRecipeAppRepository(recipeAppApi: RecipeAppApi) : RecipeAppRepository =
        RecipesAppRepositoriesImpl(recipeAppApi)
}