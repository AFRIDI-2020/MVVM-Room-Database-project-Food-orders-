package com.example.foodorders.data.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.foodorders.data.database.entity.FoodItem

@Dao
interface FoodItemDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFoodItem (foodItem : FoodItem)

    @Delete
    suspend fun deleteFoodItem (foodItem: FoodItem)

    @Query("SELECT * FROM food_items ORDER BY id ASC")
    fun getAllFood() : LiveData<List<FoodItem>>
}