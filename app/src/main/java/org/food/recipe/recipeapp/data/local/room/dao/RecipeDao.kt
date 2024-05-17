package org.food.recipe.recipeapp.data.local.room.dao


import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import org.food.recipe.recipeapp.data.dtos.Recipe

@Dao
interface RecipeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRecipes(recipes: List<Recipe>)

    @Query("SELECT * FROM recipes ORDER BY page ")
    suspend fun getRecipes() : PagingSource<Int, Recipe>
}