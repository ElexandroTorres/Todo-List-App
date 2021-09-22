package br.com.elexandro.todolistapp.extensions

import com.google.android.material.textfield.TextInputLayout
import java.text.SimpleDateFormat
import java.util.*

private val local = Locale("pt", "BR")

fun Date.format(): String {
    return SimpleDateFormat("dd/mm/yyyy").format(this)
}

var TextInputLayout.text : String
    get() = editText?.text?.toString() ?: ""
    set(value) {
        editText?.setText(value)
    }