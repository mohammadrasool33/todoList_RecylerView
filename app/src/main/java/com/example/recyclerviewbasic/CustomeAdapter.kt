package com.example.recyclerviewbasic

import android.animation.LayoutTransition
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(var todo:List<Todo>):RecyclerView.Adapter<CustomAdapter.TodoViewHolder>() {
    inner class TodoViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_todo,parent,false)
        return TodoViewHolder(view)
    }

    override fun getItemCount(): Int {
        return todo.size
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.itemView.apply{
            val title:TextView=findViewById(R.id.title)
            val checkbox:CheckBox=findViewById(R.id.checkBox)
            title.text=todo[position].title;
            checkbox.isChecked=todo[position].isChecked

        }
    }
}