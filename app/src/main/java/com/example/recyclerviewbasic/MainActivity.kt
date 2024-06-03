package com.example.recyclerviewbasic

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewbasic.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        var todoList= mutableListOf(
            Todo("learn kotlin",false),
            Todo("learn java",false),
            Todo("learn fundamental of android",false),
            Todo("learn jetpackcompose",false),
            Todo("learn database",false)
        )
        var adapter=CustomAdapter(todoList)
        binding.recyclerView.adapter=adapter
        binding.recyclerView.layoutManager=LinearLayoutManager(this)
        binding.button.setOnClickListener {
            var input=binding.editText.text.toString()
            var todo=Todo(input,false)
            todoList.add(todo)
            adapter.notifyItemInserted(todoList.size-1)

        }


    }
}