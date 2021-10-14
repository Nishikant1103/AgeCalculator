package com.example.agecalculator

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonDatePicker.setOnClickListener {
            dateSelector()
        }
    }

    private fun dateSelector() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val myPickedDate = DatePickerDialog(
            this,
            { _, selectedYear, selectedMonth, selectedDayOfMonth ->
                val selectedDate = "$selectedDayOfMonth/${selectedMonth+1}/$selectedYear"
                textViewDate.text = selectedDate
                val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
                val parsedDateOfBirth = sdf.parse(selectedDate)
                val dateOfBirthInMinutes =  parsedDateOfBirth!!.time/60000
                val dateToday = sdf.parse(sdf.format(System.currentTimeMillis()))
                val currentDateInMinutes = dateToday!!.time/60000
                val ageInMinutes = currentDateInMinutes - dateOfBirthInMinutes
                textView5.text = ageInMinutes.toString()
            },
            year,
            month,
            day
        )
        myPickedDate.datePicker.maxDate= System.currentTimeMillis()
        myPickedDate.show()
    }
}