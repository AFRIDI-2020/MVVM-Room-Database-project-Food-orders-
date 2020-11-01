package com.example.foodorders.data.repositories

import com.example.foodorders.data.database.FoodDatabase
import com.example.foodorders.data.database.entity.FoodItem

class FoodRepository(
    private val database: FoodDatabase
) {
    suspend fun inset(foodItem: FoodItem) = database.foodItemDao().insertFoodItem(foodItem)
    suspend fun delete(foodItem: FoodItem) = database.foodItemDao().deleteFoodItem(foodItem)
    fun getAllFood() = database.foodItemDao().getAllFood()
}