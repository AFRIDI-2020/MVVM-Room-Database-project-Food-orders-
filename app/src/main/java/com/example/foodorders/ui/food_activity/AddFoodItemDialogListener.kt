package com.example.foodorders.ui.food_activity

import com.example.foodorders.data.database.entity.FoodItem

interface AddFoodItemDialogListener {
    fun onAddButtonClick(foodItem: FoodItem)
}