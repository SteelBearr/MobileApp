package com.example.langlearn

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class GameRecycleViewAdapter(private val itemList: List<GameItem>, private val itemClickListener: (Int) -> Unit) : RecyclerView.Adapter<GameRecycleViewAdapter.ViewHolder>() {

    class ViewHolder(itemView: View, clickListener: (Int) -> Unit) : RecyclerView.ViewHolder(itemView) {
        val button: Button = itemView.findViewById(R.id.btnWord)
        val user: TextView = itemView.findViewById(R.id.txtUser)
        init {
            button.setOnClickListener {
                clickListener(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.game_item, parent, false)
        return ViewHolder(view, itemClickListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = itemList[position]
        holder.button.text = currentItem.word
        holder.user.text = currentItem.user
        holder.button.isSelected = currentItem.isSelected
        val context = holder.button.context
        if (currentItem.isWrong) {
            holder.button.background = context.getDrawable(R.drawable.incorrect_background)
        }
        else if (currentItem.isCorrect) {
            holder.button.background = context.getDrawable(R.drawable.correct_background)
        } else {
            holder.button.background = context.getDrawable(R.drawable.word_background)
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}