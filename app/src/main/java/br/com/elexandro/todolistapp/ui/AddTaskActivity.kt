package br.com.elexandro.todolistapp.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.elexandro.todolistapp.databinding.ActivityAddTaskBinding
import br.com.elexandro.todolistapp.datasource.TaskDataSource
import br.com.elexandro.todolistapp.extensions.format
import br.com.elexandro.todolistapp.extensions.text
import br.com.elexandro.todolistapp.model.Task
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import java.util.*

class AddTaskActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddTaskBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setListeners()
    }

    private fun setListeners() {
        binding.textInputLayoutDate.editText?.setOnClickListener {
            val datePicker = MaterialDatePicker.Builder.datePicker()
                .setTitleText("Selecione a data")
                .build()

            datePicker.addOnPositiveButtonClickListener {
                val timeZone = TimeZone.getDefault()
                val offSet = timeZone.getOffset(Date().time) * -1
                binding.textInputLayoutDate.text =  Date(it + offSet).format()
            }

            datePicker.show(supportFragmentManager, "DATE_PICKER_TAG")
        }

        binding.textInputLayoutHour.editText?.setOnClickListener {
            val timePicker = MaterialTimePicker.Builder()
                    .setTitleText("Selecione a hora")
                    .setTimeFormat(TimeFormat.CLOCK_24H)
                    .build()

            timePicker.addOnPositiveButtonClickListener {
                val hour = if (timePicker.hour in 0..9) "0${timePicker.hour}" else "${timePicker.hour}"
                val minute = if(timePicker.minute in 0..9) "0${timePicker.minute}" else "${timePicker.minute}"
                binding.textInputLayoutHour.text = "$hour : $minute"
            }

            timePicker.show(supportFragmentManager, "TIME_PICKER_TAG")
        }

        binding.buttonCancelTask.setOnClickListener {
            finish()
        }

        binding.buttonCreateTask.setOnClickListener {
            val task = Task(
                    title = binding.inputTextLayoutTitle.text,
                    description = binding.textInputLayoutDescricao.text,
                    date = binding.textInputLayoutDate.text,
                    hour = binding.textInputLayoutHour.text,
            )
            TaskDataSource.insertList(task)
            Toast.makeText(this, "Hora: ${task.hour}", Toast.LENGTH_LONG).show()
            finish()
        }
    }
}