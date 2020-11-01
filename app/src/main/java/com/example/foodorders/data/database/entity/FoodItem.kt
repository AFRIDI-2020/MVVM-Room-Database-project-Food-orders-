package com.example.foodorders.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "food_items")
class FoodItem(
    @ColumnInfo(name = "food_name") val foodName : String,
    @ColumnInfo(name = "food_amount") var foodAmount : Int
) {
    @PrimaryKey(autoGenerate = true)
    var id : Int = 0
}