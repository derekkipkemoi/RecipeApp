package org.food.recipe.recipeapp.utils

import org.food.recipe.recipeapp.R

enum class MealTypes(val mealTypeName : String, val mealTypeIcon : Int) {
    MAIN_DISH("main dish", R.drawable.main_dish),
    SIDE_DISH("side dish",R.drawable.side),
    DESSERT("dessert",R.drawable.dessert),
    APPETIZER("appetizer",R.drawable.appetizer),
    SALAD("salad",R.drawable.salad),
    BREAD("bread",R.drawable.bread),
    BREAKFAST("breakfast",R.drawable.breakfast),
    SOUP("soup",R.drawable.soup),
    BEVERAGE("beverage",R.drawable.beverages),
    SAUCE("sauce",R.drawable.sauces),
    MARINADE("marinade",R.drawable.marinade),
    FINGER_FOOD("fingerfood",R.drawable.finger_food),
    SNACK("snack",R.drawable.snack),
    DRINK("drink",R.drawable.drink)
}