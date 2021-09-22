package br.com.elexandro.todolistapp.datasource

import br.com.elexandro.todolistapp.model.Task
import java.util.*

object TaskDataSource {
    private val list: MutableList<Task> = ArrayList<Task>()


    fun getList() = list

    fun insertList(task : Task) {
        list.add(task.copy(id = list.size + 1))
    }
}