package com.example.barbershop4.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ScheduleViewModel : ViewModel() {
    private val _selectedDate = MutableLiveData<String>()
    val selectedDate: LiveData<String> get() = _selectedDate

    private val _selectedTime = MutableLiveData<String>()
    val selectedTime: LiveData<String> get() = _selectedTime

    fun setSelectedDate(date: String) {
        _selectedDate.value = date
    }

    fun setSelectedTime(time: String) {
        _selectedTime.value = time
    }
}
