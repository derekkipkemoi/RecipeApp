package org.food.recipe.recipeapp.data.local.room

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import org.food.recipe.recipeapp.domain.models.RemoteKeys

interface RemoteKeysDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(remoteKey: List<RemoteKeys>)

    @Query("SELECT * FROM remote_key WHERE recipe_id = :id")
    suspend fun getRemoteKeyByRecipeID(id: Int) : RemoteKeys

    @Query("DELETE From remote_key")
    suspend fun clearRemoteKeys()

    @Query("Select created_at From remote_key Order By created_at DESC LIMIT 1")
    suspend fun getCreationTime(): Long?
}