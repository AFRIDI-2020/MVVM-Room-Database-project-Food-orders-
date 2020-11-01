package com.example.foodorders.ui.food_activity

import androidx.lifecycle.ViewModel
import com.example.foodorders.data.database.entity.FoodItem
import com.example.foodorders.data.repositories.FoodRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FoodViewModel(private val foodRepository: FoodRepository) : ViewModel() {

    fun insert(foodItem: FoodItem) = CoroutineScope(Dispatchers.Main).launch {
        foodRepository.inset(foodItem)
    }

    fun delete(foodItem: FoodItem) = CoroutineScope(Dispatchers.Main).launch {
        foodRepository.delete(foodItem)
    }

    fun getAllFood() = foodRepository.getAllFood()


}