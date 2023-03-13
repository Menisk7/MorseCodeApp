package com.duck.morseCodeApp.ui.score

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.duck.morseCodeApp.R
import com.duck.morseCodeApp.databinding.ScoreitemBinding


class ScoreAdapter(
    val scoreItemList: List<ScoreItem>,
    private val mLayoutInflater: LayoutInflater
) : RecyclerView.Adapter<ScoreAdapter.ToDoItemHolder>() {

    class ToDoItemHolder(
        itemView: View,
        scoreItemList: List<ScoreItem>
    ) : RecyclerView.ViewHolder(itemView) {

        val todoItemUserName: TextView
        val todoItemPoints: TextView

        init {
            val todoItemBinding = ScoreitemBinding.bind(itemView)
            todoItemUserName = todoItemBinding.itemTextViewUser
            todoItemPoints = todoItemBinding.itemTextViewPoints


        }
    }

    // implement this method to use proper layout for to do items
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ToDoItemHolder {

        val view =mLayoutInflater.inflate(R.layout.scoreitem,parent,false)
        return ToDoItemHolder(view,scoreItemList)

    }


    // set the values from model data to view properly
    override fun onBindViewHolder(
        holder: ToDoItemHolder,
        position: Int
    ) {
        holder.todoItemUserName.text=scoreItemList[position].user
        holder.todoItemPoints.text= scoreItemList[position].points.toString()

    }

    override fun getItemCount(): Int = scoreItemList.size





}
