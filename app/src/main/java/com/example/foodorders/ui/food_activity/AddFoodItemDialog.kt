package com.example.foodorders.ui.food_activity

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.example.foodorders.R
import com.example.foodorders.data.database.entity.FoodItem
import kotlinx.android.synthetic.main.adding_new_food_item.*

class AddFoodItemDialog(context: Context, val addFoodItemDialogListener: AddFoodItemDialogListener) : AppCompatDialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.adding_new_food_item)

        ok_TV.setOnClickListener {
            val foodName = food_name_ET.text.toString()
            val foodAmount = food_amount_ET.text.toString()

            if(foodName.isEmpty() || foodAmount.isEmpty()){
                Toast.makeText(context, "Food name and amount are required!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val foodItem = FoodItem(foodName,foodAmount.toInt())
            addFoodItemDialogListener.onAddButtonClick(foodItem)
            dismiss()
        }

        cancel_TV.setOnClickListener {
            cancel()
        }
    }
}