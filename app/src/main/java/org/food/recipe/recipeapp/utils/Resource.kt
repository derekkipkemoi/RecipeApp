package org.food.recipe.recipeapp.utils

sealed class Resource<T>(val data:T? = null, val errorMessage: String? = null, val isLoading : Boolean = false){
    class Success<T>(data: T?, errorMessage: String? = null, isLoading: Boolean = false) : Resource<T>(data, errorMessage, isLoading)
    class Error<T>(errorMessage: String?, data: T? = null, isLoading: Boolean = false): Resource<T>(data, errorMessage, isLoading)
    class Loading<T>(isLoading: Boolean, data: T? = null, errorMessage: String? = null): Resource<T>(data, errorMessage, isLoading)
}
