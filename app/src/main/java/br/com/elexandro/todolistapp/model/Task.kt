package br.com.elexandro.todolistapp.model

data class Task(
        val id : Int =  0,
        val title : String,
        val description : String,
        val date : String,
        val hour : String
)
