package org.food.recipe.recipeapp.presentation.views.screens.home.mealTypeCategories

import org.food.recipe.recipeapp.utils.MealTypes

sealed class MealTypesData(val mealTypeName: String, val mealTypeIcon : Int){
    data object MainDish : MealTypesData(MealTypes.MAIN_DISH.mealTypeName, MealTypes.MAIN_DISH.mealTypeIcon)
    data object SideDish : MealTypesData(MealTypes.SIDE_DISH.mealTypeName, MealTypes.SIDE_DISH.mealTypeIcon)
    data object Dessert : MealTypesData(MealTypes.DESSERT.mealTypeName,MealTypes.DESSERT.mealTypeIcon )
    data object Appetizer : MealTypesData(MealTypes.APPETIZER.mealTypeName, MealTypes.APPETIZER.mealTypeIcon)
    data object Salad : MealTypesData(MealTypes.SALAD.mealTypeName,MealTypes.SALAD.mealTypeIcon )
    data object Bread : MealTypesData(MealTypes.BREAD.mealTypeName,MealTypes.BREAD.mealTypeIcon )
    data object BreakFast : MealTypesData(MealTypes.BREAKFAST.mealTypeName,MealTypes.BREAKFAST.mealTypeIcon )
    data object Soup : MealTypesData(MealTypes.SOUP.mealTypeName, MealTypes.SOUP.mealTypeIcon)
    data object Beverages : MealTypesData(MealTypes.BEVERAGE.mealTypeName,MealTypes.BEVERAGE.mealTypeIcon )
    data object Sauce : MealTypesData(MealTypes.SAUCE.mealTypeName,MealTypes.SAUCE.mealTypeIcon )
    data object Marinade : MealTypesData(MealTypes.MARINADE.mealTypeName, MealTypes.MARINADE.mealTypeIcon)
    data object FingerFood : MealTypesData(MealTypes.FINGER_FOOD.mealTypeName, MealTypes.FINGER_FOOD.mealTypeIcon)
    data object Snack : MealTypesData(MealTypes.SNACK.mealTypeName,MealTypes.SNACK.mealTypeIcon )
    data object Drink : MealTypesData(MealTypes.DRINK.mealTypeName, MealTypes.DRINK.mealTypeIcon)
}
