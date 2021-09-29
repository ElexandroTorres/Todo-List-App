package br.com.elexandro.todolistapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.elexandro.todolistapp.R
import br.com.elexandro.todolistapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    //private val adapter by lazy { TaskListAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //val linearLayoutManager = LinearLayoutManager(this)
        //binding.recycleViewTasks.layoutManager = linearLayoutManager
        //binding.recycleViewTasks.adapter = TaskListAdapter()

        insertListeners()
    }

    private fun insertListeners() {
        binding.floatingActionButtonAddTask.setOnClickListener {
            val intent = Intent(this, AddTaskActivity::class.java)
            startActivity(intent)
        }
    }
}