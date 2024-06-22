package com.example.barbershop4.view

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.barbershop4.databinding.ActivityScheduleBinding
import java.util.Calendar

class Schedule : AppCompatActivity() {

    private lateinit var binding: ActivityScheduleBinding
    private val viewModel: ScheduleViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScheduleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        viewModel.selectedDate.observe(this, Observer { date ->
            binding.tvSelectedDate.text = date
        })

        viewModel.selectedTime.observe(this, Observer { time ->
            binding.tvSelectedTime.text = time
        })

        binding.btnDatePicker.setOnClickListener {
            showDatePicker()
        }

        binding.btnTimePicker.setOnClickListener {
            showTimePicker()
        }

        binding.btnConfirm.setOnClickListener {
            Toast.makeText(this, "Agendamento com sucesso", Toast.LENGTH_SHORT).show()
            // Aqui você pode salvar o agendamento ou navegar para outra tela
        }
    }

    private fun showDatePicker() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(this, { _, selectedYear, selectedMonth, selectedDay ->
            val date = "$selectedDay/${selectedMonth + 1}/$selectedYear"
            viewModel.setSelectedDate(date)
        }, year, month, day)
        datePickerDialog.show()
    }

    private fun showTimePicker() {
        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)

        val timePickerDialog = TimePickerDialog(this, { _, selectedHour, selectedMinute ->
            val time = "$selectedHour:$selectedMinute"
            viewModel.setSelectedTime(time)
        }, hour, minute, true)
        timePickerDialog.show()
    }
}
