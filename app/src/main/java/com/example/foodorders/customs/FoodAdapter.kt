package com.example.foodorders.customs

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.foodorders.R
import com.example.foodorders.data.database.entity.FoodItem
import com.example.foodorders.ui.food_activity.FoodViewModel
import kotlinx.android.synthetic.main.food_item.view.*

class FoodAdapter(var foodItems: List<FoodItem>, private val foodViewModel: FoodViewModel) :
    RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

    inner class FoodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.food_item,parent,false)
        return FoodViewHolder(view)
    }

    override fun getItemCount(): Int {
        return foodItems.size
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {

        val fooditem = foodItems[position]
        holder.itemView.food_name_TV.text = foodItems[position].foodName
        holder.itemView.food_amount_TV.text = fooditem.foodAmount.toString()
        holder.itemView.delete_icon.setOnClickListener {
            foodViewModel.delete(fooditem)
        }

        holder.itemView.add_icon.setOnClickListener {
            fooditem.foodAmount++
            foodViewModel.insert(fooditem)
        }

        holder.itemView.remove_icon.setOnClickListener {
            fooditem.foodAmount--
            foodViewModel.insert(fooditem)
        }
    }
}