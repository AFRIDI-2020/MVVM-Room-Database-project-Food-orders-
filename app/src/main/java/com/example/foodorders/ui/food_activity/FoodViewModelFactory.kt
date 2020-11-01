package com.example.foodorders.ui.food_activity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.foodorders.data.repositories.FoodRepository

@Suppress("UNCHECKED_CAST")
class FoodViewModelFactory(val foodRepository: FoodRepository) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return FoodViewModel(foodRepository) as T
    }
}