package com.example.foodorders.ui.food_activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodorders.R
import com.example.foodorders.customs.FoodAdapter
import com.example.foodorders.data.database.FoodDatabase
import com.example.foodorders.data.database.entity.FoodItem
import com.example.foodorders.data.repositories.FoodRepository
import kotlinx.android.synthetic.main.activity_food.*

class FoodActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food)

        val foodDatabase = FoodDatabase(this)
        val foodRepository = FoodRepository(foodDatabase)
        val factory = FoodViewModelFactory(foodRepository)
        val viewModel = ViewModelProvider(this,factory).get(FoodViewModel::class.java)

        val foodAdapter = FoodAdapter(listOf(),viewModel)
        display_food_list_RV.layoutManager = LinearLayoutManager(this)
        display_food_list_RV.adapter = foodAdapter

        viewModel.getAllFood().observe(this, Observer {
            foodAdapter.foodItems = it
            foodAdapter.notifyDataSetChanged()
        })

        add_food_item_button.setOnClickListener {
            AddFoodItemDialog(this, object : AddFoodItemDialogListener{
                override fun onAddButtonClick(foodItem: FoodItem) {
                    viewModel.insert(foodItem)
                }

            }).show()
        }


    }
}